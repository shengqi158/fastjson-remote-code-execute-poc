package person;

/**
 * Created by web on 2017/4/18.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializeToFlatFile {
    public static void main(String[] args) {
        SerializeToFlatFile ser = new SerializeToFlatFile();
        ser.savePerson();
        ser.restorePerson();
    }

    public void savePerson(){
        Person myPerson = new Person("Jay",24);
        try {
            FileOutputStream fos = new FileOutputStream("myPerson.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Person--Jay,24---Written");
            System.out.println("Name is: "+myPerson.getName());
            System.out.println("Age is: "+myPerson.getAge());

            oos.writeObject(myPerson);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void restorePerson() {
        try {
            FileInputStream fis = new FileInputStream("myPerson.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person myPerson = (Person)ois.readObject();
            System.out.println("\n--------------------\n");
            System.out.println("Person--Jay,24---Restored");
            System.out.println("Name is: "+myPerson.getName());
            System.out.println("Age is: "+myPerson.getAge());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}