import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^[+-]?[0|1-9][\\d]*[.,][\\d]*[1-9]$|" +
                "^[+-]?[1-9][\\d]*[.,][\\d]$|" +
                "^[+-]?[\\d][.,][\\d]|^[+-]?[1-9][\\d]+";

        String number = scanner.nextLine();
        System.out.println(number.matches(regex) ? "YES" : "NO");
    }
}