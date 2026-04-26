package java_hw_3;

import java.util.Scanner;

public class OS_Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which program do you want to download? : ");
        String program = scanner.nextLine();

        System.out.println("Which OS do you use" + "? : ");
        String OS = scanner.nextLine();

        String link = "";
        switch (program.toLowerCase()) {
            case "intellij idea":
                switch (OS.toLowerCase()) {
                    case "windows":
                        link = "https://www.jetbrains.com/idea/download/?section=windows";
                        break;
                    case "linux":
                        link = "https://www.jetbrains.com/idea/download/?section=linux";
                        break;
                    case "macos":
                        link = "https://www.jetbrains.com/idea/download/?section=macos";
                        break;
                    default:
                        System.out.println("Invalid OS");
                        return;
                }
                break;
            case "git":
                switch (OS.toLowerCase()) {

                    case "windows":
                        link = "https://git-scm.com/download/windows";
                        break;
                    case "linux":
                        link = "https://git-scm.com/download/linux";
                        break;
                    case "macos":
                        link = "https://git-scm.com/download/mac";
                        break;
                    default:
                        System.out.println("Invalid OS");
                        return;
                }
                break;
            case "java":
                switch (OS.toLowerCase()) {
                    case "windows":
                        link = "https://www.oracle.com/europe/java/technologies/downloads/#java17-windows";
                        break;
                    case "linux":
                        link = "https://www.oracle.com/europe/java/technologies/downloads/#java17-linux";
                        break;
                    case "macos":
                        link = "https://www.oracle.com/europe/java/technologies/downloads/#java17-mac";
                        break;
                        default:
                            System.out.println("Invalid OS");
                            return;
                }
             break;
                default:
                    System.out.println("Invalid Program");
                    return;
        }
        System.out.println("Here you can download the program " + link);
    }
}
