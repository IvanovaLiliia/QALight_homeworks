package java_hw_3;

import java.util.Scanner;

public class ScaTest {
    public static void main(String[] args) {

        int[] array = {16, 9, 6, 9, 9, 2, 55, 9, 4, 1, 55};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter some number: ");
        int number = scanner.nextInt();

        int count = 0;

        for (int num : array) {
            if (num == number) {
                count++;
            }
        }
        System.out.println("The Quantaty: " + count);
        scanner.close();
    }
}