import classes_folder.BinaryTree;
import com.vitaly.classes.Person;
import com.vitaly.interfaces.FunctionalIntTest;
import java_folder.Client;
import java_folder.JetBrainsEntryExam;

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

/**
 * Documentation program helloworld
 * @author Vitaly
 * @version 1.0
 */

public class HelloWorld {
    final static Integer inta = 1;

    public static void doShit(int a, int b, FunctionalIntTest ft) {
        if (ft.wtf(a, b) > 0) {
            System.out.println(a + ">" + b);
        } else if (ft.wtf(a, b) < 0){
            System.out.println(a + "<" + b);
        } else {
            System.out.println(a + "=" + b);
        }
    }
    public static void main(String[] args) {
//        System.out.println(LeetCodeTasks.canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));

        BinaryTree tree = new BinaryTree();
        BinaryTree.Node node4 = new BinaryTree.Node(4);
        BinaryTree.Node node5 = new BinaryTree.Node(5);
        BinaryTree.Node node1 = new BinaryTree.Node(1);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node7 = new BinaryTree.Node(7);
        BinaryTree.Node node0 = new BinaryTree.Node(0);

        tree.add(4);
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(7);
        tree.add(0);

        tree.print(System.out);



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