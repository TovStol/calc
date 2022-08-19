import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Введите выражение: ");
            String input = console.nextLine();
            System.out.println("Результат операции: " + calc(input));
        }
    }

    public static String calc(String input) throws Exception {

        String[] splitPlus = input.split("\\+");
        String[] splitMinus = input.split("-");
        String[] splitMultip = input.split("\\*");
        String[] splitDiv = input.split("/");

        if (splitPlus.length + splitMinus.length + splitMultip.length + splitDiv.length != 5)
            throw new Exception("Не верное выражение");

        if (splitPlus.length == 2) {
            if (checkRim(splitPlus[0]) > 0 && checkRim(splitPlus[1]) > 0)
                return
                        (rimToArab((checkRim(splitPlus[0]) + checkRim(splitPlus[1]))));
            else if (checkArab(splitPlus[0]) > 0 && checkArab(splitPlus[1]) > 0)
                return
                        String.valueOf((checkArab(splitPlus[0]) + checkArab(splitPlus[1])));
            else throw new Exception("Не допустимые числа");
        }
        if (splitMinus.length == 2) {
            if ((checkRim(splitMinus[0]) > 0
                    && checkRim(splitMinus[1]) > 0)
                    && (checkRim(splitMinus[0]) > checkRim(splitMinus[1])))
                return
                        (rimToArab((checkRim(splitMinus[0]) - checkRim(splitMinus[1]))));
            if (checkArab(splitMinus[0]) > 0 && checkArab(splitMinus[1]) > 0)
                return
                        String.valueOf((checkArab(splitMinus[0]) - checkArab(splitMinus[1])));
            else throw new Exception("Не допустимые числа");
        }
        if (splitMultip.length == 2) {
            if (checkRim(splitMultip[0]) > 0 && checkRim(splitMultip[1]) > 0)
                return
                        (rimToArab((checkRim(splitMultip[0]) * checkRim(splitMultip[1]))));
            else if (checkArab(splitMultip[0]) > 0 && checkArab(splitMultip[1]) > 0)
                return
                        String.valueOf((checkArab(splitMultip[0]) * checkArab(splitMultip[1])));
            else throw new Exception("Не допустимые числа");
        }
        if (splitDiv.length == 2) {
            if (checkRim(splitDiv[0]) > 0 && checkRim(splitDiv[1]) > 0)
                return
                        (rimToArab((checkRim(splitDiv[0]) / checkRim(splitDiv[1]))));
            else if (checkArab(splitDiv[0]) > 0 && checkArab(splitDiv[1]) > 0)
                return
                        String.valueOf((checkArab(splitDiv[0]) / checkArab(splitDiv[1])));
            else throw new Exception("Не допустимые числа");
        }
        return null;

    }

    static int checkRim(String temp) {
       return switch (temp) {
            case "I":
                yield 1;
            case "II":
                yield 2;
            case "III":
                yield 3;
            case "IV":
                yield 4;
            case "V":
                yield 5;
            case "VI":
                yield 6;
            case "VII":
                yield 7;
            case "VIII":
                yield 8;
            case "IX":
                yield 9;
            case "X":
                yield 10;
            default:
                yield -1;
        };

    }

    static int checkArab(String temp) {
        return switch (temp) {
            case "1":
                yield 1;
            case "2":
                yield 2;
            case "3":
                yield 3;
            case "4":
                yield 4;
            case "5":
                yield 5;
            case "6":
                yield 6;
            case "7":
                yield 7;
            case "8":
                yield 8;
            case "9":
                yield 9;
            case "10":
                yield 10;
            default:
                yield -1;
        };
    }

    static String rimToArab(int rim) {
        String[] rimDec = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] rimEdin = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String edin = "";
        String dec = "";
        for (int i = 10; i >= 1; i--) {
            if (rim / (i * 10) == 1) {
                dec = rimDec[i - 1];
                break;
            }
        }
        for (int j = 9; j >= 1; j--) {
            if (rim % 10 == j ) {
                edin = rimEdin[j - 1];
                break;
            }
        }
        return dec + edin;
    }
}