import algorythms.*;
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
import java.util.stream.Stream;

import classes_folder.LeetCodeTasks;
import com.vitaly.interfaces.FunctionalIntTest;
import java_folder.Person;
import leetcode.EasyPeasy;

/**
 * Documentation program helloworld
 * @author Vitaly
 * @version 1.0
 */

public class HelloWorld {
    final static Integer inta = 1;
    private static final String pathToProperties = "E:\\Java Projects\\First_project\\src\\prop.properties";

    public static void main(String[] args) throws IOException {
       int[] prices = {7,6,4,3,1};
        System.out.println(LeetCodeTasks.maxProfit2(prices));
    }

    static Graph<Integer> createGraph() {
        Graph<Integer> last = new Graph<Integer>(12, null);
        Graph<Integer> a4 = new Graph<Integer>(4, new HashMap<>(){{put(last, 2);}});
        Graph<Integer> a6 = new Graph<Integer>(6, new HashMap<>(){{put(last, 5);}});
        Graph<Integer> a2 = new Graph<Integer>(2, new HashMap<>(){{put(a4, 3); put(a6, 1);}});
        Graph<Integer> a3 = new Graph<Integer>(3, new HashMap<>(){{put(a6, 4);}});
        Graph<Integer> head = new Graph<Integer>(1, new HashMap<>(){{put(a2, 4); put(a3, 5);}});

        return head;
    }

    static BinaryTree createTree() {
        BinaryTree leftnode3 = new BinaryTree(1);
        BinaryTree rightnode3 = new BinaryTree(3);
        BinaryTree leftnode2 = new BinaryTree(2, leftnode3, rightnode3);
        BinaryTree rightnode33 = new BinaryTree(7);
        BinaryTree leftnode33 = new BinaryTree(5);
        BinaryTree rightnode2 = new BinaryTree(6, leftnode33, rightnode33);
        BinaryTree root = new BinaryTree(4, leftnode2, rightnode2);

        return root;
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

class Tester {
    public String name;

    public Tester(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tester tester = (Tester) o;
        return Objects.equals(name, tester.name);
    }

    @Override
    public int hashCode() {
        if (name.length() % 2 == 0)
            return 22;
        else
            return 33;
    }
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