import java.util.ArrayList;
import java.util.Scanner; 

public class ToDo {
    
    public static void clear_screen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public ArrayList<String> createListTask(){
        ArrayList<String> tasks = new ArrayList<>();
        return tasks;
    }

    public static ArrayList<String> AddItem(ArrayList<String> listTask, Scanner input){
        System.out.println("Write the element for add in the list"); 
        String addItemWrite = input.nextLine();
        listTask.add(addItemWrite);
        return listTask;
    }

    public static doubleResult deleteItem(ArrayList<String> listTask, Scanner input){
        System.out.println("Write the element for delete in the list"); 
        String deleteItem = input.nextLine();
        listTask.remove(deleteItem);
        return new doubleResult(listTask, deleteItem);
    }

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        ToDo toDo = new ToDo();
        boolean bucle_temp = true;
        
        ArrayList<String> listTasks = toDo.createListTask();
       
        while(bucle_temp){
            
            System.out.println("*** To Do list ***");
            System.out.println("[1] Show Tasks");
            System.out.println("[2] Add Task");
            System.out.println("[3] Delete Tasks");
            System.out.println("[4] Exit.");
            String select_option = input.nextLine();
            
            switch(select_option){
                case "1":
                    for(int i=0; i < listTasks.size(); i++){
                        System.out.println(i + " - " + listTasks.get(i));
                    }
                    select_option = "";
                    input.nextLine();
                    clear_screen();
                    break;
                
                case "2":
                    listTasks = AddItem(listTasks, input);
                    System.out.println(listTasks); 
                    select_option = "";
                    input.nextLine();
                    clear_screen();
                    break;
                case "3":
                    doubleResult listTask =  deleteItem(listTasks, input);
                    System.out.println("Item delete: " + listTask.getItem());
                    System.out.println("List Task update: " + listTask.getList());
                    input.nextLine();
                    clear_screen();
                    break;
                case "4":
                    bucle_temp = false;
                    clear_screen();
                    break;
                default:
                    System.out.println("Invalid Option try again");
                    break;
            }
                
        }
        input.close();
    }
}


class doubleResult {
    private ArrayList<String> list;
    private String item; 
    public doubleResult(ArrayList<String> list, String item){
        this.list = list;
        this.item = item;
    }

    public ArrayList<String> getList(){
        return list;
    }

    public String getItem(){
        return item;
    }
    
}