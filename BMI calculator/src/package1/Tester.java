package package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

    public static int id;
    static String name;
    static String yob;
    static int height;
    static int weight;
    static Bmi bmi;
    public static List<Bmi> users = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    System.out.println("Please Enter User Id");
                    choice = scanner.nextInt();
                    view(choice);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public static void displayMenu() {
        System.out.println("--BMI CALCULATOR--");
        System.out.println("");
        System.out.println("1.Create a record");
        System.out.println("2.Show BMI data for all users. ");
        System.out.println("3.Show BMI data of a selected user");
        System.out.println("4.Delete the records ");
        System.out.println("5.Exit ");
        System.out.println("");
        System.out.println("Please Enter Your decision ");

    }

    public static void view(int id) { // show onw record
        users.forEach(user -> {
            if (user.getId() == id) {
                user.display();
            }
        });
    }

    public static void create() {

        System.out.println("Enter your id:");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your name:");
        name = scanner.nextLine();
        System.out.println("Enter your year of birth:");
        yob = scanner.nextLine();
        System.out.println("Enter your height:");
        height = scanner.nextInt();
        System.out.println("Enter your weight:");
        weight = scanner.nextInt();

        bmi = new Bmi(id, name, yob, height, weight);
        users.add(bmi);
        index();
        System.out.println(users.size());

//        displayMenu();
//        scanner.nextLine();
    }

    public static void index() {
        users.forEach(user -> user.display());

    }

    public static void delete() {
        users.clear();
    }

    public static void exit() {
        System.exit(0);
    }

}
