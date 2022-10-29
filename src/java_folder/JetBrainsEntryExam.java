package java_folder;
import java.util.Objects;
import java.util.Scanner;

public class JetBrainsEntryExam {
    public void firstTask() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println((number % 100)/10);
    }

    public void secondTask() {
        String city = "M";
        String capital = null;
        Objects.equals(capital,"Melbourne");
        if (city != null) {
            System.out.println(city.substring(0,2));
        }
    }

    public void thirdTask(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int num = scanner.nextInt();
        int counter = 0;
        while (num != 0) {
            counter++;
            num = scanner.nextInt();
        }
        System.out.println(counter);
    }

    public void fourthTask() {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        if (city.length() >= 4) {
            if (city.substring(city.length() - 4).equals("burg")) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } else {
            System.out.println("false");
        }
        System.out.println(city.substring(city.length() - 4) + " " + "burg");
    }

    public int sign(int number) {
        if (number > 0)
            return 1;
        else if (number == 0)
            return 0;
        else
            return -1;

    }
}
