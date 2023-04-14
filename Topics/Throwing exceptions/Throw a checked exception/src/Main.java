import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void method() throws FileNotFoundException {
        File file = new File("text.txt");

        if (!file.exists()) {
            throw new FileNotFoundException("File not found!");
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        try {
            method();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}