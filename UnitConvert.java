import java.util.Scanner; 


public class UnitConvert {
    public static final double CONST_KELVIN = 274.1;
    public static final double CONST_FAHREN_1 = 1.8;
    public static final double CONST_FAHREN_2 = 32;
    public static final double CONST_CELSIUS_1 = 0.555;
    public static Scanner input  = new Scanner(System.in);
    
    public static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void Temperature(){

        ClearScreen();
        System.out.println("[1] Celsius -> Kelvin");
        System.out.println("[2] Celsius -> Fahrenheit");
        System.out.println("[3] Kelvin -> Celsius");
        System.out.println("[4] Kelvin -> Fahrenheit");
        System.out.println("[5] Fahrenheit -> Celsius");
        System.out.println("[6] Fahrenheit -> Kelvin");
        String convertype = input.nextLine();
        System.out.println("Write the temperature to convert: ");
        double temp1 = input.nextFloat();
        switch(convertype){
            case "1":
                temp1 = temp1 + CONST_KELVIN;
                System.out.println("The temperature in Kelvin is: " + temp1);
                break;
            
            case "2":
                temp1 = (temp1 * CONST_FAHREN_1)  + CONST_FAHREN_2;
                System.out.println("The temperature in Kelvin is: " + temp1);
                break;
            case "3":
                temp1 = temp1 - CONST_KELVIN;
                System.out.println("The temperature in Celsius is: " + temp1);
            case "4":
                temp1 = (temp1 - CONST_KELVIN) * CONST_FAHREN_1 + CONST_FAHREN_2;
                System.out.println("The temperature in Fahrenheit : " + temp1);
                break; 
            case "5":
                temp1 = (temp1 - CONST_FAHREN_2) * CONST_CELSIUS_1;
                System.out.println("The temperature in Celsius is: " + temp1); 
                break; 
            case "6":
                temp1 = (temp1 - CONST_FAHREN_2) * CONST_CELSIUS_1 + CONST_KELVIN;
                System.out.println("The temperature in Keviln is: " + temp1);
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public static void Weight(){
        System.out.println("[1] Kg - Lbs"); 
        System.out.println("[2] Lbs - Kg");
        System.out.println("[3] Kg - grams");
        System.out.println("[4] Lbs - oz"); 
        System.out.println("[5] Grams - Kg");
        System.out.println("[6] Oz - Lbs"); 
    }
    
    public static void Length(){
        System.out.println("[1] Meter - cm"); 
        System.out.println("[2] cm - meter");
        System.out.println("[3] km - meter");
        System.out.println("[4] in - yd"); 
        System.out.println("[5] yd - in");
        System.out.println("[6] yd - mi"); 

    }
    public static void main(String[] args) {
        boolean flag_1 = true;
        
       
        
        while(flag_1){
            System.out.println(">[1] Temperature");
            System.out.println(">[2] Weight");
            System.out.println(">[3] Length");
            System.out.println(">[4] Exit");
            String selec_input = input.nextLine();

            switch(selec_input){
                case "1":
                    Temperature();
                    break;

                case "2":
                    Weight();
                    break;
                case "3":
                    Length();
                    break; 
                case "4":
                    break;
                default:
                    System.out.println("Incorrect option, please choose other");
                    break;
            }
            System.out.println("Do you want continue: [Y/N]");
            String continue_conv = input.nextLine();
            System.out.println(continue_conv);
            if(continue_conv.equals("y")){
                flag_1 = true;
            }
            else{
                flag_1 = false;
            }
        }
        input.close();
    }
    
}