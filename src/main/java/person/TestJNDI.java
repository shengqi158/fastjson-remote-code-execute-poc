package person;

import javax.naming.*;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;


/**
 * Created by liaoxinxi on 2017-9-5.
 */
public class TestJNDI {
    public static void testLdap(){
        String url = "ldap://127.0.0.1:1389";
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        try{
            DirContext dirContext = new InitialDirContext(env);
            System.out.println("connected");
            System.out.println(dirContext.getEnvironment());
            Reference e = (Reference) dirContext.lookup("e");

        }catch(NameNotFoundException ex){
            ex.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void testRmi() throws NamingException {
        String url = "rmi://127.0.0.1:1099";
        Hashtable env = new Hashtable();
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        Context context = new InitialContext(env);
        //Object object = context.lookup("Exploit");//ok
        Object object1 = context.lookup("rmi://127.0.0.1/Exploit");
        //System.out.println("Object:" + object);
    }
    public static void main(String[] argv) throws NamingException {
        testRmi();

    }
}
