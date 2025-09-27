//Use Case 1 → Ebook Reader (Adapter Pattern)
package structura_design_pattern;
import java.util.Scanner;

interface Reader {
    void read(String file);
}

class PdfFile {
    void open(String f) {
        System.out.println("Open pdf: " + f);
    }
}

class WordFile {
    void open(String f) {
        System.out.println("Open word: " + f);
    }
}

class PdfAdapter implements Reader {
    PdfFile p = new PdfFile();

    public void read(String f) {
        p.open(f);
    }
}

class WordAdapter implements Reader {
    WordFile w = new WordFile();

    public void read(String f) {
        w.open(f);
    }
}

public class Adapter_pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the PDF file to read (e.g., maths.pdf): ");
        String pdfFileName = scanner.nextLine();
        Reader pdfReader = new PdfAdapter();
        pdfReader.read(pdfFileName);

        System.out.print("Enter the name of the Word file to read (e.g., notes.docx): ");
        String wordFileName = scanner.nextLine();
        Reader wordReader = new WordAdapter();
        wordReader.read(wordFileName);

        scanner.close();
    }
}
