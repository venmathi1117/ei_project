//Use Case 2 → Creating Learning Materials
package creational_design_pattern;

import java.util.Scanner;

interface Material {
    void show();
}

class Video implements Material {
    public void show() {
        System.out.println("Video Material");
    }
}

class PDF implements Material {
    public void show() {
        System.out.println("PDF Material");
    }
}

class Quiz implements Material {
    public void show() {
        System.out.println("Quiz Material");
    }
}

class MaterialFactory {
    public static Material getMaterial(String type) {
        if (type.equalsIgnoreCase("video")) return new Video();
        if (type.equalsIgnoreCase("pdf")) return new PDF();
        if (type.equalsIgnoreCase("quiz")) return new Quiz();
        return null;
    }
}

public class Factory_pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the type of material (video, pdf, quiz): ");
        String type = scanner.nextLine();
        
        Material material = MaterialFactory.getMaterial(type);
        
        if (material != null) {
            material.show();
        } else {
            System.out.println("Invalid material type. Please enter video, pdf, or quiz.");
        }
        
        scanner.close();
    }
}
