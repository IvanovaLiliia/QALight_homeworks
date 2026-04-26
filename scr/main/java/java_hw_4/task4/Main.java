package java_hw_4.task4;

public class Main {
    public static void main(String[] args) {

        Team team = new Team(3);


        Student student1 = new Student("George", 35);
        Student student2 = new Student("Liliia", 30);
        Student student3 = new Student("Maria", 25);

        team.addStudent(student1);
        team.addStudent(student2);
        team.addStudent(student3);

        team.printStudents();
    }
}