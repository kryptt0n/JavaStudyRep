import java_folder.Client;
import java_folder.Person;

/**
 * Documentation program helloworld
 * @author Vitaly
 * @version 1.0
 */


public class HelloWorld {
    final static Integer inta = 1;
    public static void main(String[] args)  {
        Hehe lolo = new Lolo();


    }

    public static void changePerson(Person p){
        p.setName("Vitos");
    }
}

class Hehe {
    public void sayhi(){
        System.out.println("hi");
    }
}

class Lolo extends Hehe {
    public void sayhi(int lol){
        System.out.println("lolo");
    }
    public void test(){
        System.out.println("test");
    }
}

