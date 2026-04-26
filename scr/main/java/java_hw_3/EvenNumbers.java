package java_hw_3;

public class EvenNumbers {
    public static void main(String[] args) {
         int [] numbers = { 5, 2, 8, 5, 19, 22, 1, 50};
         int count = 0;


         for (int i = 0; i < numbers.length; i++) {
             if (numbers[i] % 2 == 0) {
                 count++;
             }
         }
         System.out.println(count);
    }
}
