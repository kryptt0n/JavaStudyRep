package java_folder;

public class Client extends Human{

    public String bank_name;

    public Client(String name, String bank_name) {
        super(name);
        this.bank_name = bank_name;
    }

    @Override
    public void say_hi() {
        System.out.println(String.format("Hello, my name is %s. Im a client in %s bank", name, bank_name));
    }
}
