import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int max = IntStream.range(0, number)
                .map(s -> scanner.nextInt())
                .filter(i -> i % 4 == 0)
                .max()
                .orElse(Integer.MAX_VALUE);

        System.out.println(max);
    }
}