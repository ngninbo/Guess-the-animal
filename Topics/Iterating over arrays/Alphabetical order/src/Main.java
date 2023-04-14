import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        boolean alphabeticalSorted = false;

        for (int i = 0; i < words.length - 1; i++) {
            alphabeticalSorted = words[i].compareTo(words[i + 1]) < 1;
        }

        System.out.println(alphabeticalSorted);
    }
}