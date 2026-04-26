package java_hw_4.task3;

public class MAIN {

    public static void main(String[] args) {

        Circle[] circles = new Circle[3];

        circles[0] = new Circle(4.5);
        circles[1] = new Circle(4.0);
        circles[2] = new Circle(7.2);


        for (int i = 0; i < circles.length; i++) {
            System.out.println("Circle is " + (i + 1));
            System.out.println("Radius is : " + circles[i].getRadius());
            System.out.println("Area is : " + circles[i].getArea());
            System.out.println("Circumference is : " + circles[i].getCircumference());
            System.out.println();
        }
    }
}
