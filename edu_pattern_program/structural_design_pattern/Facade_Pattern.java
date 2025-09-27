//Use Case 1 → Dashboard (Facade Pattern)

package structura_design_pattern;

import java.util.Scanner;

class Course {
    void show() {
        System.out.println("Course info");
    }
}

class Exam {
    void show() {
        System.out.println("Exam info");
    }
}

class Result {
    void show() {
        System.out.println("Result info");
    }
}

class Dashboard {
    Course c = new Course();
    Exam e = new Exam();
    Result r = new Result();

    void displayAll() {
        c.show();
        e.show();
        r.show();
    }

    void displayCourse() {
        c.show();
    }

    void displayExam() {
        e.show();
    }

    void displayResult() {
        r.show();
    }
}

public class Facade_Pattern {
    public static void main(String[] args) {
        Dashboard d = new Dashboard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose what to display:");
        System.out.println("1. Course Info");
        System.out.println("2. Exam Info");
        System.out.println("3. Result Info");
        System.out.println("4. All Info");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                d.displayCourse();
                break;
            case 2:
                d.displayExam();
                break;
            case 3:
                d.displayResult();
                break;
            case 4:
                d.displayAll();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

        scanner.close();
    }
}
