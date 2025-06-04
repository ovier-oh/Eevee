import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    static ArrayList<String> listTasks;
    static boolean bucle_temp;

    public static void clear_screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void createListTask() {
        listTasks = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ToDo toDo = new ToDo();
        bucle_temp = true;

        toDo.createListTask();

        while (bucle_temp) {
            printOptions();
            String select_option = input.nextLine();

            processSelection(select_option, input);

            System.out.println("Press enter to continue.....");
            input.nextLine();
            clear_screen();

        }
        input.close();
    }

    private static void printOptions() {
        System.out.println("*** To Do list ***");
        System.out.println("[1] Show Tasks");
        System.out.println("[2] Add Task");
        System.out.println("[3] Delete Tasks");
        System.out.println("[4] Exit.");
    }

    private static void processSelection(String select_option, Scanner input) {
        switch (select_option) {
            case "1":
                showTasks();
                break;

            case "2":
                addTask(input.nextLine());
                break;
            case "3":
                deleteTask(input.nextLine());
                break;
            case "4":
                exit();
                break;
            default:
                System.out.println("Invalid Option try again");
                break;
        }
    }

    private static void exit() {
        bucle_temp = false;
    }

    private static void deleteTask(String deleteItem) {
        System.out.println("Write the element to delete from the list");

        if (!listTasks.contains(deleteItem)) {
            System.out.println("The task does not exist in the list");
        } else {
            listTasks.remove(deleteItem);
        }

        System.out.println("Item to delete: " + deleteItem);
        System.out.println("List Task updated: " + listTasks);
    }

    private static void addTask(String addItemWrite) {
        System.out.println("Write the element to add to the list");
        listTasks.add(addItemWrite);
        System.out.println(listTasks);
    }

    private static void showTasks() {
        for (int i = 0; i < listTasks.size(); i++) {
            System.out.println(i + " - " + listTasks.get(i));
        }
    }
}

