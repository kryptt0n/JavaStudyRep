public final class Employee extends Person{
    String company;

    Employee(String name, String company){
        super(name);
        this.company = company;

    }

    @Override
    public void sayHi() {
        super.sayHi();
        System.out.println(String.format("works in %s", company));
    }
}
