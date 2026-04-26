package java_hw_3;

public class NegativeNumbers {
    public static void main(String[] args) {


        int [] array = {9, -3, 11, -4, -10, 7, -15};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
        for (int number : array) {
            System.out.println( number + " ");
        }
    }
}
