package com.vitaly.classes;

import jdk.jfr.Name;

import java.io.*;

@Name("persona")
public final class Person implements Serializable {

    public  int retirementAge = 50;
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + id;
    }

    public void save(OutputStream fileOutputStream) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
            outputStream.writeObject(this);
        } catch (IOException e) {

        }

    }

    public void load(InputStream fileInputStream) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person temp = (Person) objectInputStream.readObject();
            this.name = temp.getName();
            this.id = temp.getId();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void sayHello() {
        System.out.println("Hello!");
    }
}
