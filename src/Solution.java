import java.util.Scanner;


public class Solution {
    static String variable1;
    static String variable2;
    static char symbol;

    public static String validation(String string) throws Exception {
        if (string.matches("^[0-9\\s*]{1,2}[\\+|\\-|\\/|\\*][\\s*0-9]{1,2}")) {
            return "arab";
        } else if (string.matches("^[IVX\\s*]+[\\+|\\-|\\/|\\*][\\s*IVX]+")) {
            return "rome";
        } else throw new Exception();
    }


    public static void segmentation(String string) {
        int index1 = 0;
        for (int i = 0; i < string.length(); i++) {
            symbol = string.charAt(i);
            if (symbol == '+' || symbol == '-' || symbol == '/' || symbol == '*') {
                index1 = string.indexOf(symbol);
                break;
            }
        }
        variable1 = string.substring(0, index1);
        variable2 = string.substring(index1 + 1, string.length());

    }

    public static Integer resultForArab() throws Exception {
        int number1 = Integer.parseInt(variable1);
        int number2 = Integer.parseInt(variable2);
        return result(number1, number2);
    }

    public static int result(int number1, int number2) throws Exception {

        if (number1 < 11 && number1 > 0 && number2 < 11 && number2 > 0) {
            if (symbol == '+')
                return number1 + number2;
            else if (symbol == '-')
                return number1 - number2;
            else if (symbol == '/')
                return number1 / number2;
            else
                return number1 * number2;
        } else throw new Exception();
    }

    public static void Text() {
        System.out.println("Ввод выражения:\n");
    }

    public static void main(String[] args) throws Exception {
        Text();
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }

    static String calc(String input) throws Exception {
        String arabOrRome = validation(input);
        input = input.replaceAll(" ", "");
        segmentation(input);
        if (arabOrRome.equals("arab"))
            return resultForArab().toString();
        else
            return resultForRome();
    }

    public static String resultForRome() throws Exception {
        String[] rome = new String[2];
        rome[0] = variable1;
        rome[1] = variable2;
        int[] numb = new int[2];
        for (int i = 0; i < 2; i++) {
            if (rome[i].equals("I"))
                numb[i] = 1;
            else if (rome[i].equals("II"))
                numb[i] = 2;
            else if (rome[i].equals("III"))
                numb[i] = 3;
            else if (rome[i].equals("IV"))
                numb[i] = 4;
            else if (rome[i].equals("V"))
                numb[i] = 5;
            else if (rome[i].equals("VI"))
                numb[i] = 6;
            else if (rome[i].equals("VII"))
                numb[i] = 7;
            else if (rome[i].equals("VIII"))
                numb[i] = 8;
            else if (rome[i].equals("IX"))
                numb[i] = 9;
            else if (rome[i].equals("X"))
                numb[i] = 10;
            else throw new Exception();
        }
        int number1 = numb[0];
        int number2 = numb[1];
        return resultToRome(number1, number2);
    }

    public static String resultToRome(int number1, int number2) throws Exception {
        int resRome = result(number1, number2);
        String romeStr = "";
        if (resRome <= 0)
            throw new Exception();
        while (resRome != 0) {
            if (resRome == 100) {
                romeStr += "C";
                resRome -= 100;
            } else if (resRome >= 50 && resRome < 90) {
                romeStr += "L";
                resRome -= 50;
            } else if (resRome >= 90 && resRome < 100) {
                romeStr += "XC";
                resRome -= 90;
            } else if (resRome >= 40 && resRome < 50) {
                romeStr += "XL";
                resRome -= 40;
            } else if (resRome >= 10 && resRome < 40) {
                romeStr += "X";
                resRome -= 10;
            } else if (resRome == 9) {
                romeStr += "IX";
                resRome -= 9;
            } else if (resRome >= 5 && resRome < 9) {
                romeStr += "V";
                resRome -= 5;
            } else if (resRome == 4) {
                romeStr += "IV";
                resRome -= 4;
            } else if (resRome >= 1 && resRome < 4) {
                romeStr += "I";
                resRome -= 1;
            }
        }
        return romeStr;
    }
}
