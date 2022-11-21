import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static Operation operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Enter your expression:");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = Operation.SUM; // Required type Operation; Provided: char
            }
            if (under_char[i] == '-') {
                operation = Operation.SUB;
            }
            if (under_char[i] == '*') {
                operation = Operation.MULT;
            }
            if (under_char[i] == '/') {
                operation = Operation.DIV;
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] parts = under_charString.split("[+-/*]");
        String numera0 = parts[0];
        String numera1 = parts[1];
        String cutNumera1 = numera1.trim();
        number1 = romanToNum(numera0);
        number2 = romanToNum(cutNumera1);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = operation.action(number1, number2);
            //римские цифры
            String resultRoman = inputToRoman(result);
            System.out.println(resultRoman);
        }
        number1 = Integer.parseInt(numera0);
        number2 = Integer.parseInt(cutNumera1);
        result = operation.action(number1, number2);
        //арабские цифры
        System.out.println(result);
    }

    private static String inputToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNum (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Incorrect data form");
        }
        return -1;
    }

    public static int calc (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Incorrect operation");
        }
        return result;
    }
}