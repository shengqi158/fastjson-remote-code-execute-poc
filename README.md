fastjson remote code execute poc 
直接用intellij IDEA打开即可
首先编译得到Test.class，然后运行Poc.java

支持jdk1.7，1.8
该poc只能运行在fastjson-1.2.22到fastjson-1.2.24版本区间，因为fastjson从1.2.22版本才开始引入SupportNonPublicField

详情分析：http://xxlegend.com/2017/04/29/title-%20fastjson%20%E8%BF%9C%E7%A8%8B%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96poc%E7%9A%84%E6%9E%84%E9%80%A0%E5%92%8C%E5%88%86%E6%9E%90/

基于JNDI的poc，JdbcRowSetImplPoc.java
1，在远程服务器上运行server中的JNDIServer或者LdapServer
2，将Exploit.class放到上述服务指定的位置，一般都是web服务目录下
3，执行JdbcRowSetImplPoc.java
