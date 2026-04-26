package java_hw_3;

public class Arrays_MaxNumber {
    public static void main(String[] args) {


        int [] numbers = {5, 1, 9, 25, 2, 3, 8};
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println(max);

    }
}
