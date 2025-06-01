import java.lang.Math;
import java.util.Scanner;

public class guess_number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int try_user = 0;
        //define range 
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        int num_rand = (int)(Math.random() * range) + min;
        
        while(true){
            System.out.println("You number of tries is: " + try_user);
            System.out.println("Please, write a number: ");
            int number_user = input.nextInt();
            if(number_user == num_rand){
                System.out.println("Congratulations, You Guess the number: ");
                System.out.println("The number of tries are: " + try_user);
                System.out.println(num_rand);
                break;
            }
            else if (number_user > num_rand){
                try_user++ ;
                System.out.println("sorry, the number you put is greater.");
                System.out.println("Try again :D.");
                input.nextLine(); //
                
            }
            else if (number_user < num_rand){
                try_user += 1;
                System.out.println("sorry, the number you put is less.");
                System.out.println("Try again :D");
                input.nextLine(); //
                
            }
        }
        input.close();

    }
}