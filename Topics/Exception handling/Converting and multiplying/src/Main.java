import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.tokens()
                .takeWhile(s -> !"0".equals(s))
                .forEach(Main::printAfterConversion);
    }

    private static void printAfterConversion(String s) {
        System.out.println(s.matches("\\d+") ? convertAndMultiply(s) : "Invalid user input: " + s);
    }

    private static int convertAndMultiply(String s) {
        return new BigInteger(s).multiply(BigInteger.TEN).intValue();
    }
}