import java.util.InputMismatchException;
import java.util.Scanner;
public  class calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1,numbers2;
    static char operation;
    static int result;
    public static void main(String[] args) {
        System.out.println("Введите выражение [2+2] или два римских числа:");
        String good = scanner.nextLine();
        char[] big_char = new char[10];
        for (int i = 0; i < good.length(); i++) {
            big_char[i] = good.charAt(i);
            if (big_char[i] == '+') {
                operation = '+';
            }
            if (big_char[i] == '-') {
                operation = '-';
            }
            if (big_char[i] == '*') {
                operation = '*';
            }
            if (big_char[i] == '/') {
                operation = '/';
            }
        }
        String big_charString = String.valueOf(big_char);
        String[] bags = big_charString.split("[+-/*]");
        String bag0 = bags[0];
        String bag1 = bags[1];
        String string03 = bag1.trim();
        number1 = twilightToNumber(bag0);
        numbers2 = twilightToNumber(string03);
        if (number1 < 0 && numbers2 < 0) {
            result = 0;
        } else {
            result = calculator(number1, numbers2, operation);
            System.out.println("-Результат для римсих цифр-");
            String resultTwilight = convertNumTwilight(result);
            System.out.println(bag0 + " " + operation + " " + string03 + " = " + resultTwilight);
        }
        number1 = Integer.parseInt(bag0);
        numbers2 = Integer.parseInt(string03);
        result = calculator(number1, numbers2, operation);
        System.out.println("-Результат для Арабских цифр-");
        System.out.println(number1 + " " + operation + " " + numbers2 + " = " + result);
    }
    private static String convertNumTwilight(int numArabian) {
        String [] twilight = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    final String s = twilight[numArabian];
        return s;
    }
    private static int twilightToNumber(String twilight) {
        try {
            if (twilight.equals("I")) {
                return 1;
            } else if (twilight.equals("II")) {
                return 2;
            } else if (twilight.equals("III")) {
                return 3;
            } else if (twilight.equals("IV")) {
                return 4;
            } else if (twilight.equals("V")) {
                return 5;
            } else if (twilight.equals("VI")) {
                return 6;
            } else if (twilight.equals("VII")) {
                return 7;
            } else if (twilight.equals("VIII")) {
                return 8;
            } else if (twilight.equals("IX")) {
                return 9;
            } else if (twilight.equals("X")) {
                return 10;
            }
        } catch(InputMismatchException e ){
                throw new InputMismatchException("Неверный фомат данных");
            }
            return -1 ;
    }
    public static int calculator(int num1,int num2,char op){
        int result = 0;
        switch(op) {
            case '+':
                result =  num1 + num2;
                break;
            case  '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
               try {
                   result = num1  /  num2;
               } catch (ArithmeticException | InputMismatchException e){
                System.out.println("Исключение:" +  e  );
                System.out.println("Разрешены только целые ненулевые параметры");
                break;
            }
            break;
            default:
                throw new IllegalArgumentException("Не верный знак операций");
        }
        return result;
    }
}





