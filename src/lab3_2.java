import java.util.Arrays;
import java.util.Scanner;

public class lab3_2 {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int[] mainArray = new int[0];
        int number_to_annihilate;
        try {
            System.out.print("Число к удалению: ");
            number_to_annihilate= Integer.parseInt(scan.nextLine());
            System.out.print("Введите массив: ");
            main_loop:
            for (; ; ) {
                String line = scan.nextLine();
                for (String text : line.split(" ")) {
                    if (text.equals("quit"))
                        break main_loop;
                    if (text.length() != 0) {
                        mainArray = Arrays.copyOf(mainArray, mainArray.length + 1);
                        mainArray[mainArray.length - 1] = Integer.parseInt(text);
                    }
                }
            }
        } catch (NumberFormatException ignore) {
            System.out.println("Ошибка, массив и число к удалению должны быть целыми");
            return;
        }
        System.out.print("Исходный массив: ");
        for (int elem : mainArray) {
            System.out.print(elem + " ");
        }
        System.out.println();
        int left_count = 0;
        for (int i = 0; i < mainArray.length; i++) {
            mainArray[left_count] = mainArray[i];
            if (mainArray[i] != number_to_annihilate) {
                left_count++;
            }
        }
        mainArray = Arrays.copyOf(mainArray, left_count);
        System.out.print("Массив после обработки: ");
        for (int elem : mainArray) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}