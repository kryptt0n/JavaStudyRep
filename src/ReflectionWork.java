import com.vitaly.classes.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionWork {
    public static void main(String[] args) {
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
}
