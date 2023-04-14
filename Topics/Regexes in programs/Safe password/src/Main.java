import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        System.out.println(isSafe(password) ? "YES" : "NO");
    }

    private static boolean isSafe(String password) {
        String regex = "^(?=.*[0-9]{1,})(?=.*[a-z]{1,})(?=.*[A-Z]{1,}).{12,}";

        return password.matches(regex);
    }
}