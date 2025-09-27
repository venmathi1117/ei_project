import java.util.Scanner;

public class Authentication {
    public static boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (user.equals("admin") && pass.equals("admin123")) {
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid credentials.");
        return false;
    }
}
