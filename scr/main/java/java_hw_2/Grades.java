package java_hw_2;

public class Grades {
    public static void main(String[] args) {


        int grade = 69;

        if (grade > 100) {
            System.out.println("Ви ввели невірну оцінку");
        }
        else if (grade >= 90)
            System.out.println("Відмінно");
        else if (grade >= 70)
            System.out.println("Добре");
        else if (grade >= 50)
            System.out.println("Задовільно");
        else if (grade >= 0)
            System.out.println("Незадовільно");
        else
            System.out.println("Оцінка не може бути нижче 0");

    }
}
