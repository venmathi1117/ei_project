//Use Case 2 → Adaptive Learning
package Design_pattern;

import java.util.Scanner;

interface LearnMethod {
    void learn(String sub);
}

class Video implements LearnMethod {
    public void learn(String sub) {
        System.out.println("Learn " + sub + " by video");
    }
}

class Quiz implements LearnMethod {
    public void learn(String sub) {
        System.out.println("Learn " + sub + " by quiz");
    }
}

class LearningSystem {
    LearnMethod m;

    void set(LearnMethod m1) {
        m = m1;
    }

    void start(String sub) {
        m.learn(sub);
    }
}

public class Strategy_Pattern {
    public static void main(String[] args) {
        LearningSystem sys = new LearningSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the subject you want to learn: ");
        String subject = scanner.nextLine();

        System.out.print("Choose learning method (1 for Video, 2 for Quiz): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            sys.set(new Video());
        } else if (choice == 2) {
            sys.set(new Quiz());
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
            scanner.close();
            return; 
        }

        sys.start(subject);
        scanner.close();
    }
}
