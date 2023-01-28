package com.vitaly.classes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass {
    public static void main(String[] args) {
        Util normalUtil = new Util("Normal", 222);
        //Работает только с интерфесами
        UtilInterface handledUtil = (UtilInterface) Proxy.newProxyInstance(normalUtil.getClass().getClassLoader(),
                normalUtil.getClass().getInterfaces(),
                new CustomInvocationHandler(normalUtil));
        normalUtil.sayHi();
        handledUtil.sayHi();

    }
}

interface UtilInterface {
    void sayHi();
}

class Util implements UtilInterface {

    private String name;
    private int age;

    public Util(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHi() {
        System.out.println("Hello, my name is " + name + " im " + age);
    }
}

class CustomInvocationHandler implements InvocationHandler {

    private Util baseUtil;

    public CustomInvocationHandler(Util baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("sayHi")) {
            System.out.println("Hi from handler");
        }

        return null;
    }
}
