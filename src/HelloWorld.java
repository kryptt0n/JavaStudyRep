import algorythms.BinarySearch;
import algorythms.MergeSort;
import classes_folder.BinaryTree;
import com.vitaly.classes.Person;
import com.vitaly.classes.computers.Computer;
import com.vitaly.classes.computers.ComputerComparator;
import com.vitaly.interfaces.FunctionalIntTest;
import java_folder.Client;
//import java_folder.JetBrainsEntryExam;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

import classes_folder.LeetCodeTasks;
import com.vitaly.interfaces.FunctionalIntTest;
import leetcode.EasyPeasy;

/**
 * Documentation program helloworld
 * @author Vitaly
 * @version 1.0
 */

public class HelloWorld {
    final static Integer inta = 1;
    private static final String pathToProperties = "E:\\Java Projects\\First_project\\src\\prop.properties";

    public static void doShit(int a, int b, FunctionalIntTest ft) {
        if (ft.wtf(a, b) > 0) {
            System.out.println(a + ">" + b);
        } else if (ft.wtf(a, b) < 0){
            System.out.println(a + "<" + b);
        } else {
            System.out.println(a + "=" + b);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.toUnsignedString(-1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(0b11111111111111111111111111111100 - 0b000000000000000000100);

        // 100 + 1100
    }

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    static int reverseNum(int num) {
        int number = num;
        int tempVal = num % 10;
        int res = 0;
        while (number != 0) {
            tempVal = number % 10;
            res = res * 10 + tempVal;
            number /= 10;
        }
        return res;
    }

    static int andrewAndAcid() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> acid = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < size; i++) {
            acid.add(scanner.nextInt());
        }

        int max = acid.get(0);
        for (int i = 0; i < acid.size(); i++) {
            max = Math.max(acid.get(i), max);
            if (acid.get(i) < max) {
                answer = -1;
                break;
            }
        }
        if (answer == 0) {
            return acid.stream().max((a, b) -> a - b).get() - acid.stream().min((a, b) -> a - b).get();
        } else
            return answer;

    }

    static boolean isSorted (ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < arrayList.get(i - 1))
                return false;
        }
        return true;
    }



}

interface A {

}

interface B {

}

interface C extends A, B {

}



class Runner implements Runnable {

    private static int counter;

    public int id;

    public Runner() {
        counter++;
        id = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("" + id + " goes " + i + " time");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}