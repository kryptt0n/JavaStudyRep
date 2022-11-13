import com.vitaly.classes.Person;
import com.vitaly.classes.PrivateClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class ReflectionWork {
    public static void main(String[] args) {
        try {
            workWithPrivateAttributes();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

    private static void workWithClasses() {
        try {
            //Получение класса зная класс до компиляции
            Class cl = HelloWorld.class;
            //Получение класса зная только имя (Выбрасывает ошибку)
            Class find = Class.forName("com.vitaly.classes.Person");

            System.out.println(find.getName() + "\n" + find.getSimpleName());
            System.out.println(Arrays.toString(find.getAnnotations()));
            //Получение модификаторов
            Integer modifiers = find.getModifiers();
            System.out.println(modifiers.byteValue());
            System.out.println(modifiers);
            //Получение родительского класса
            Class superclass = find.getSuperclass();
            System.out.println(superclass.getName());
            //Получение конструкторов класса
            Constructor[] constructors = find.getConstructors();
            System.out.println(Arrays.toString(constructors));
            //Получение конструктора с определенными параметрами
            Constructor specificConstructor = find.getConstructor(int.class, String.class);
            //Создание объекта по конструктору
            Person newPerson = (Person) specificConstructor.newInstance(15, "Vitos");
            System.out.println(newPerson.toString());

        } catch (ClassNotFoundException e) {
            System.out.println("class was not found");
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("uuops");
        }
    }

    private static void workWithFields() {
        try {
            Class classpersona = Person.class;
            //Получить все public поля
            Field[] fields = classpersona.getFields();
            //Получить public поле по имени
            Field specificOne = classpersona.getField("retirementAge");
            System.out.println(Arrays.toString(fields));
            //Получить тип поля
            Object fieldType = specificOne.getType();
            System.out.println(fieldType);
            //Установка значения поля для конкретного объекта
            Constructor specificConstructor = classpersona.getConstructor(int.class, String.class);
            Person newPerson = (Person) specificConstructor.newInstance(15, "Vitos");
            specificOne.set(newPerson, 32);
            System.out.println(newPerson.retirementAge);

        } catch (Exception e) {

        }
    }

    private static void workWithMethods() {
        try {
            Class persona = Person.class;
            //Получение всех public методов
            Method[] methods = persona.getMethods();
            System.out.println(Arrays.toString(methods));
            Method specificMethod = persona.getDeclaredMethod("sayHello");
            Class[] paramTypes = specificMethod.getParameterTypes();
            Class returnType = specificMethod.getReturnType();

            System.out.println(paramTypes + " " + returnType);
        } catch (Exception e) {

        }
    }

    private static void workWithPrivateAttributes() throws Exception {
        Class privateClass = PrivateClass.class;
        //получить ВСЕ методы (даже приватные)
        Method[] privateMethods = privateClass.getDeclaredMethods();
        //получить ВСЕ поля
        Field[] privateFields = privateClass.getDeclaredFields();
        System.out.println(privateFields + "\n" + privateMethods);
        Field specificField = privateClass.getDeclaredField("number");
        Constructor constructor = privateClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        PrivateClass instance = (PrivateClass) constructor.newInstance();
        //Отключаем обязательно проверку, иначе компилятор не даст работать с приват полем
        specificField.setAccessible(true);
        //Получаем значение поля
        System.out.println(specificField.get(instance));
        //Меняем значение поля
        specificField.set(instance, 50);
        System.out.println(specificField.get(instance));

    }
}
