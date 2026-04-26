package java_hw_4.task4;

public class Team {
    private Student [] students;
    private int count;

    public Team(int size) {
        this.students = new Student[size];
        this.count = 0;
    }

    public void addStudent(Student student) {
        if (this.count < this.students.length) {
            this.students[this.count] = student;
            this.count++;
        }
        else {
            System.out.println("The team is full");
        }
    }
        public void printStudents() {
            if (this.count == 0) {
                System.out.println("The list of students is empty");
                return;
            }
            for (int i = 0; i < this.count; i++) {
                System.out.println("Student " + (i + 1));
                System.out.println("Name: " + this.students[i].getName());
                System.out.println("Age: " + this.students[i].getAge());
                System.out.println();
            }
    }
}
