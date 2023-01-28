package java_folder;

import com.vitaly.annotations.CoolAnnotation;

public class Client extends Human{

    public String bank_name;

    public Client(String name, String bank_name) {
        super(name);
        this.bank_name = bank_name;
    }

    @Override
    @CoolAnnotation(5)
    public void say_hi() {
        System.out.println(String.format("Hello, my name is %s. Im a client in %s bank", name, bank_name));
    }

    @Override
    public String toString() {
        return String.format("%s works in %s",this.name, bank_name);
    }
}
