package java_folder;

abstract public class Human {
    public String name;

    public Human(String name) {
        this.name = name;
    }

    public abstract void say_hi();

    public void human_void() {
        System.out.println("Im still a human");
    }
}
