/**
 * Documentation program helloworld
 * @author Vitaly
 * @version 1.0
 */


public class HelloWorld {
    public static void main(String[] args)  {
        Lol lol = new Lol();
        lol.say_hi();

    }

    public static void changePerson(Person p){
        p.setName("Vitos");
    }
}

abstract class TestInheritance {
    private String name = "hellp";
    public int age = 10;
    protected boolean kid = false;
    float f = 1.0f;
    public void displayInfo() {
        System.out.println(this.name);
    }

}

class Test {
    protected void say_hi(){
        System.out.println("Hello");
    }
}

class Lol extends Test {
    @Override
    public void say_hi() {
        System.out.println("WEW");

    }
}