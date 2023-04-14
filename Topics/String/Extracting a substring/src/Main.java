import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int from = scanner.nextInt();
        int to = scanner.nextInt() + 1;
        System.out.println(text.substring(from, to));
    }
}