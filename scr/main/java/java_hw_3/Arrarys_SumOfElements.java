package java_hw_3;

public class Arrarys_SumOfElements {


    public static void main(String[] args) {

        int [] numbers = {3, 7, 8, 1, 9, 2, 3};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }
}
