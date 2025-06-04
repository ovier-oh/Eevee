import java.util.Scanner; 
import java.util.Arrays;

public class TicTacToe{
    public static String matrixtoe[][] = {{"1","2","3"},{"4","5","6"},{"7","8","9"}}; 
    public static Scanner input = new Scanner(System.in);
    public static String player_1 = "";
    public static String player_2 = "";
    public static String currentPlayer = "";
    public static boolean loop = true;

    public static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void greetings(){
        System.out.println("**Welcome to TicTacToe Game**");
        System.out.println("[Info] The First participant in create 3 in line Wins!!");

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
                System.out.println("--+--+--");
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

    public static boolean position_loc(int[] position, String player){
        int row = position[0]; 
        int col = position[1]; 
        
        if(!matrixtoe[row][col].equals("X") && !matrixtoe[row][col].equals("O")){
            matrixtoe[row][col]=player; 
            return checkwinner(row, col, player);
        }
        else{
            System.out.println("[Error] Esa posicion ya esta ocupada.");
            return false;
        }
    }

    public static boolean checkwinner(int row, int col, String player){
        // Verificar fila
        if (matrixtoe[row][0].equals(player) && matrixtoe[row][1].equals(player) && matrixtoe[row][2].equals(player)) {
            return true;
        }
        // Verificar columna
        if (matrixtoe[0][col].equals(player) && matrixtoe[1][col].equals(player) && matrixtoe[2][col].equals(player)) {
            return true;
        }
        // Verificar diagonal principal
        if (row == col) {
            if (matrixtoe[0][0].equals(player) && matrixtoe[1][1].equals(player) && matrixtoe[2][2].equals(player)) {
                return true;
            }
        }
        // Verificar diagonal secundaria
        if (row + col == 2) {
            if (matrixtoe[0][2].equals(player) && matrixtoe[1][1].equals(player) && matrixtoe[2][0].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBoardFull(){
        for (int i = 0; i < matrixtoe.length; i ++){
            for(int j = 0; j < matrixtoe[i].length; j++){
                if (!matrixtoe[i][j].equals("X") && !matrixtoe[i][j].equals("O")){
                    return false;
                }
            }
        }
        return true;
    }

    public static void game_turns(String player1, String player2){
        while(true){
            //Section for change player 
            if (currentPlayer.equals(player1)){
                currentPlayer = player2; 
            }
            else{
                currentPlayer = player1;
            }
            

            System.out.println("[Info] Please look the game board, here one number is one position");
            matix_tictactoe();
            System.out.println("[Info] Player: " + currentPlayer + " You only need write the number of position that you want :D");
            String turn_position = input.nextLine(); 
            int[] position = position_select(turn_position);

            if(position != null){
                boolean hasWon = position_loc(position, currentPlayer);
                ClearScreen();          
                matix_tictactoe();

                if(hasWon){
                    System.out.println("[Info] Game Over, Winner is: " + currentPlayer + "!");
                    break;
                }
                else if(isBoardFull()){
                    System.out.println("[Info] Game Over, Tie no player Won!");
                }
            }
            else{
                System.out.println("[Error] Posicion Invalida!");
            }
        }
    }

    public static void main(String[] args){
        greetings();
        input.nextLine();
        System.out.println("[Info] You can choose one player [O] or [X]");
        String [] players = players();
        String player1 = players[0];
        String player2 = players[1];
        System.out.println("You are: " + player1 +" | Other player is:" + player2);
        input.nextLine();
        ClearScreen();
        game_turns(player1, player2);
    }
}