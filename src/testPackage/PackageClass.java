package testPackage;

public class PackageClass {
    public static void main(String[] args) {
        Student st = new Student("Vitaly", 22);
        st.PrintInfo();
    }
}

class Student {

    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void PrintInfo() {
        System.out.println("Hello " + this.name + ". Im " + age);
    }
}
