//Use Case 1 → Online Course Registration

package creational_design_pattern;

import java.util.Scanner;

class CoursePortal {
    private static CoursePortal obj;

    private CoursePortal() {}

    public static CoursePortal getInstance() {
        if (obj == null) obj = new CoursePortal();
        return obj;
    }

    void register(String name) {
        System.out.println(name + " registered");
    }
}

public class Singleton_pattern {
    public static void main(String[] args) {
        CoursePortal p1 = CoursePortal.getInstance();
        CoursePortal p2 = CoursePortal.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to register: ");
        String name = scanner.nextLine();

        p1.register(name);
        System.out.println("Are both instances the same? " + (p1 == p2));

        scanner.close();
    }
}
