package person;

/**
 * Created by web on 2017/4/18.
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable{
    private String name;
    private int age;
    public Person(){
        System.out.println("in no param constructor");
    }
    public Person(String str, int n){
        System.out.println("Inside Person's Constructor");
        name = str;
        age = n;
    }
    String getName(){
        System.out.println("in getName");
        return name;
    }
    void setName(String str){
        System.out.println("in setname");
        this.name = str;
    }

    void setAge(int age){
        System.out.println("in setAge");
        this.age = age;
    }
    int getAge(){
        System.out.println("in getAge");
        return age;
    }
}
