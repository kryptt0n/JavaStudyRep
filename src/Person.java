public class Person {
    int age;
    String name;

    Account account;

    {
        age = 0;
        name = "B4 Initiation";
        account = new Account("qwerty");
    }

    Person() {
        age = 1;
        name = "Default";
        account = new Account("qwerty");
    }
    Person(String Name){
        age = 1;
        setName(Name);
        account = new Account("qwerty");
    }
    Person(String Name, int Age){
        setName(Name);
        setAge(Age);
        account = new Account("qwerty");
    }

    public void setAge(int age) {
        if (age > 0 && age < 110){
            this.age = age;
        }
    }


    public class Account {
        private String pass;

        Account(String pass) {
            this.pass = pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getPass() {
            return pass;
        }
    }

    public void sayPasswordFromAcc() {
        System.out.println(Person.this.account.getPass());
    }

    public void changePassword(String pass){
        this.account.setPass(pass);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void sayHi(){
        System.out.println(name + " " + age);
    }
}
