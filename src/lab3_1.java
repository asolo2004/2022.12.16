import java.util.Arrays;
import java.util.Scanner;

public class lab3_1 {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        double[] mainArray;
        mainArray = new double[0];
        try {
            System.out.print("Введите массив: ");
            main_loop:
            for (; ; ) {
                String line = scan.nextLine();
                for (String text : line.split(" ")) {
                    if (text.equals("quit"))
                        break main_loop;
                    if (text.length() != 0) {
                        mainArray = Arrays.copyOf(mainArray, mainArray.length + 1);
                        mainArray[mainArray.length - 1] = Double.parseDouble(text);
                    }
                }
            }
        } catch (NumberFormatException ignore) {
            System.out.println("Неправильный ввод!");
            return;
        }
        System.out.print("Исходный массив: ");
        for (double elem : mainArray) {
            System.out.print(Double.toString(elem).replaceFirst("\\.0+$", "") + " ");
        }
        System.out.println();
        double sum = 0.0;
        for (int i = 0; i < mainArray.length; i++) {
            sum += mainArray[i];
            mainArray[i] = sum / (i+1);
        }
        System.out.print("Массив после обработки: ");
        for (double elem : mainArray) {
            System.out.print(Double.toString(elem).replaceFirst("\\.0+$", "") + " ");
        }
        System.out.println();
    }
}
