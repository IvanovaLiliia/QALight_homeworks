package java_hw_3;

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод сторон
        System.out.print("Enter side a: ");
        int a = scanner.nextInt();

        System.out.print("Enter side b: ");
        int b = scanner.nextInt();

        System.out.print("Enter side c: ");
        int c = scanner.nextInt();


        if (canFormTriangle(a, b, c)) {
            System.out.println("Triangle formed");
        } else {
            System.out.println("Triangle with such sides does not exist");
        }

        scanner.close();
    }

    public static boolean canFormTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}