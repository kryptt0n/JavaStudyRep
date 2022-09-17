package java_folder;

public final class Employee extends Human{
    public String bank_name;

    Employee(String name, String bank_name){
        super(name);
        this.bank_name = bank_name;

    }

    @Override
    public void say_hi() {
        System.out.println(String.format("Hello, Im %s. I work in %s bank", name, bank_name));
    }
}
