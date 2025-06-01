import java.util.Scanner; 
import java.util.Arrays;

public class TicTacToe{
    public static String matrixtoe[][] = {{"1","2","3"},{"4","5","6"},{"7","8","9"}}; 
    public static Scanner input = new Scanner(System.in);
    public static String player_1 = "";
    public static String player_2 = "";
    public static boolean loop = true;

    public static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void greetings(){
        System.out.println("**Welcome to TicTacToe Game**");
        System.out.println("[Info] The First participant in create 3 in line Wins!!");
        System.out.println("[Info] You can choose one player [O] or [X]");
    }

    public static void matix_tictactoe(){
        for (int i=0; i < matrixtoe.length; i++){
            for(int j=0; j < matrixtoe[i].length; j++){
                System.out.print(matrixtoe[i][j]);
                if(j < matrixtoe[i].length - 1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(i < matrixtoe.length - 1){
                System.out.println("-- -- --");
            }
        }
    }

    public static String[] players(){
        System.out.println("Please, Take one player [1] or [2]");
        String player = input.nextLine(); 
        if (player.equals("1")) {
            player_1 = "O";
            player_2 = "X";
        }
        if (player.equals("2")){
            player_2 = "O";
            player_1 = "X";
        }
        return new String[]{player_1, player_2};
    }

    public static int[] position_select(String position){
        switch(position){
            case "1": return new int[]{0,0};
            case "2": return new int[]{0,1};
            case "3": return new int[]{0,2};
            case "4": return new int[]{1,0};
            case "5": return new int[]{1,1};
            case "6": return new int[]{1,2};
            case "7": return new int[]{2,0};
            case "8": return new int[]{2,1};
            case "9": return new int[]{2,2}; 
            default: return null;           
        }
    }

    public static void game_turns(String player1, String currentPlayer){
        while(true){
            



            System.out.println("[Info] Please look the game board, here one number is one position");
            matix_tictactoe();
            System.out.println("[Info] You only need write the number of position that you want :D");
            String turn_position = input.nextLine(); 
            int[] position = position_select(turn_position);
            if(position != null){
                position_loc(position, currentPlayer);
                ClearScreen();
                matix_tictactoe();
            }
            else{
                System.out.println("[Error] Posicion Invalida!");
            }
        }
    }

    public static void position_loc(int[] position, String player){
        int row = position[0]; 
        int col = position[1]; 

        if(!matrixtoe[row][col].equals("X") && !matrixtoe[row][col].equals("O")){
            matrixtoe[row][col]=player; 
        }
        else{
            System.out.println("[Error] Esa posicion ya esta ocupada.");
        }
    }

    public static void main(String[] args){
        greetings();
        input.nextLine();
        System.out.println("[Info] You can choose one player [O] or [X]");
        String [] players = players();
        String player1 = players[0];
        String player2 = players[1];
        System.out.println("You are: " + player1 + " Other player is:" + player2);
        input.nextLine();
        ClearScreen();
        game_turns(player1, player2);
    }
}