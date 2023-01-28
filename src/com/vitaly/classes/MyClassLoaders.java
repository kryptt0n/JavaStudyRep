package com.vitaly.classes;

import java.util.ArrayList;

public class MyClassLoaders {

    public static void main(String[] args) {

        Class myclass = Generics.class;
        Class stringClass = String.class;

        System.out.println(myclass.getClassLoader().getName());
        System.out.println(stringClass.getClassLoader().getName());

        ClassLoader loader;
        ArrayList ar;


    }

}
