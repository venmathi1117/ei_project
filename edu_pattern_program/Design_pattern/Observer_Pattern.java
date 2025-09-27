//Use Case 1 → Online Mentorship
package Design_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Student {
    void update(String msg);
}

class Mentor {
    List<Student> list = new ArrayList<>();

    void add(Student s) {
        list.add(s);
    }

    void notifyAll(String msg) {
        for (Student s : list) {
            s.update(msg);
        }
    }
}

class Learner implements Student {
    String name;

    Learner(String n) {
        name = n;
    }

    public void update(String msg) {
        System.out.println(name + " got: " + msg);
    }
}

public class Observer_Pattern {
    public static void main(String[] args) {
        Mentor m = new Mentor();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of learners to add: ");
        int numberOfLearners = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numberOfLearners; i++) {
            System.out.print("Enter the name of learner " + (i + 1) + ": ");
            String name = scanner.nextLine();
            m.add(new Learner(name));
        }

        System.out.print("Enter the message to notify all learners: ");
        String message = scanner.nextLine();

        m.notifyAll(message);
        scanner.close();
    }
}
