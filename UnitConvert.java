import java.util.Scanner;


public class UnitConvert {
    public static final double CONST_KELVIN = 274.1;
    public static final double CONST_FAHREN_1 = 1.8;
    public static final double CONST_FAHREN_2 = 32;
    public static final double CONST_CELSIUS_1 = 0.555;
    public static Scanner input = new Scanner(System.in);

    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void Temperature() {
        ClearScreen();
        System.out.println("[1] Celsius -> Kelvin");
        System.out.println("[2] Celsius -> Fahrenheit");
        System.out.println("[3] Kelvin -> Celsius");
        System.out.println("[4] Kelvin -> Fahrenheit");
        System.out.println("[5] Fahrenheit -> Celsius");
        System.out.println("[6] Fahrenheit -> Kelvin");

        String convertType = input.nextLine();
        Temperature temperature = null;

        switch (convertType) {
            case "1":
                temperature = Temperature.CELSIUS_KELVIN;
                break;

            case "2":
                temperature = Temperature.CELSIUS_FAHRENHEIT;
                break;

            case "3":
                temperature = Temperature.KELVIN_CELSIUS;
                break;

            case "4":
                temperature = Temperature.KELVIN_FAHRENHEIT;
                break;

            case "5":
                temperature = Temperature.FAHRENHEIT_CELSIUS;
                break;

            case "6":
                temperature = Temperature.FAHRENHEIT_KELVIN;
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }

        if (temperature != null) {
            double value = getValueToConvert();
            convert(temperature, value);
        }
    }

    private static double getValueToConvert() {
        boolean isValid = false;
        double value = 0;

        while (!isValid) {
            System.out.println("Write the temperature to convert: ");

            try {
                value = Double.parseDouble(input.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("The value entered is not a number");
            }
        }
        return value;
    }

    private static void convert(Temperature temperature, double temp) {
        double converted = 0.0;
        String unit = "";

        switch (temperature) {
            case Temperature.CELSIUS_KELVIN:
                converted = temp + CONST_KELVIN;
                unit = "Kelvin";
                break;
            case Temperature.CELSIUS_FAHRENHEIT:
                converted = (temp * CONST_FAHREN_1) + CONST_FAHREN_2;
                unit = "Fahrenheit";
                break;
            case Temperature.KELVIN_CELSIUS:
                converted = temp - CONST_KELVIN;
                unit = "Celsius";
                break;
            case Temperature.KELVIN_FAHRENHEIT:
                converted = (temp - CONST_KELVIN) * CONST_FAHREN_1 + CONST_FAHREN_2;
                unit = "Fahrenheit";
                break;
            case Temperature.FAHRENHEIT_CELSIUS:
                converted = (temp - CONST_FAHREN_2) * CONST_CELSIUS_1;
                unit = "Celsius";
                break;
            case Temperature.FAHRENHEIT_KELVIN:
                converted = (temp - CONST_FAHREN_2) * CONST_CELSIUS_1 + CONST_KELVIN;
                unit = "Kelvin";
            default:
                System.out.println("Invalid option.");
                break;

        }
        String msg = String.format("The temperature in %s is: %f", unit, converted);
        System.out.println(msg);
    }

    public static void Weight() {
        System.out.println("[1] Kg - Lbs");
        System.out.println("[2] Lbs - Kg");
        System.out.println("[3] Kg - grams");
        System.out.println("[4] Lbs - oz");
        System.out.println("[5] Grams - Kg");
        System.out.println("[6] Oz - Lbs");
    }

    public static void Length() {
        System.out.println("[1] Meter - cm");
        System.out.println("[2] cm - meter");
        System.out.println("[3] km - meter");
        System.out.println("[4] in - yd");
        System.out.println("[5] yd - in");
        System.out.println("[6] yd - mi");

    }

    public static void main(String[] args) {
        boolean flag_1 = true;

        while (flag_1) {
            System.out.println(">[1] Temperature");
            System.out.println(">[2] Weight");
            System.out.println(">[3] Length");
            System.out.println(">[4] Exit");
            String select_input = input.nextLine();

            Type type = getType(select_input);

            switch (type) {
                case TEMPERATURE:
                    Temperature();
                    break;
                case WEIGHT:
                    Weight();
                    break;
                case LENGTH:
                    Length();
                    break;
                default:
                    break;
            }

            System.out.println("Do you want continue: [Y/N]");

            String continue_conv = input.nextLine();
//            System.out.println(continue_conv);

            flag_1 = continue_conv.equals("y");
        }
        input.close();
    }

    private static Type getType(String select_input) {
        Type type = null;
        switch (select_input) {
            case "1":
                type = Type.TEMPERATURE;
                break;

            case "2":
                type = Type.WEIGHT;
                break;
            case "3":
                type = Type.LENGTH;
                break;
            case "4":
                break;
            default:
                System.out.println("Incorrect option, please choose other");
                break;
        }
        return type;
    }

    public enum Temperature {
        CELSIUS_KELVIN,
        CELSIUS_FAHRENHEIT,
        KELVIN_CELSIUS,
        KELVIN_FAHRENHEIT,
        FAHRENHEIT_CELSIUS,
        FAHRENHEIT_KELVIN
    }

    public enum Type {
        TEMPERATURE,
        WEIGHT,
        LENGTH
    }

}
