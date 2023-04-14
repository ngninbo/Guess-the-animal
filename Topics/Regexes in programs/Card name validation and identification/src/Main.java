import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BankCard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String numbers = scn.nextLine();
        String card = numbers.replaceAll("\\s", "");

        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = getRegex();
        String americanExpressRegex = "^3[47]\\d{13}$";

        if (card.matches(visaRegex)) {
            System.out.println("Visa");
        } else if (card.matches(masterCardRegex)) {
            System.out.println("MasterCard");
        } else if (card.matches(americanExpressRegex)) {
            System.out.println("AmericanExpress");
        } else {
            System.out.println("Card number does not exist");
        }
    }

    private static String getRegex() {
        final int from = 23;
        final int to = 72;
        return IntStream.range(from, to)
                .mapToObj(i -> String.format("%s\\d|", i))
                .collect(Collectors.joining("", "^5[1-5]\\d{14}$|^2(22[1-9]|", String.format("%s0)\\d{12}$", to)));
    }
}