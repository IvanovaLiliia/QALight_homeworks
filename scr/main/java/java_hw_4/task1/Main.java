package java_hw_4.task1;

public class Main {

    public static void main(String[] args) {

        Student[] students = new Student[5];

        students[0] = new Student("Liliia", "Ivanova", 30);
        students[1] = new Student("Mary", "Tkachenko", 18);
        students[2] = new Student("Vitaliy", "Sidorov", 22);
        students[3] = new Student("George", "Seleznev", 35);
        students[4] = new Student("Yuliia", "Kivalchuk", 52);

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println(student.getFullName());

        }
    }
}
