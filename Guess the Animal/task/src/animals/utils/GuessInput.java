package animals.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuessInput {

    public static String requestInput(String message) {
        System.out.printf("%s%n", message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public static String requestFact(String firstAnimal, String secondAnimal) {

        String fact = "";

        while (!getMatcher(fact).find()) {
            fact = getDistinguishingFact(firstAnimal, secondAnimal);
        }

        return fact;
    }

    private static String getDistinguishingFact(String firstAnimal, String secondAnimal) {
        String message = MessageRessource.getInstance().getProperty("guess.game.session.distinguishing.fact.request.text");
        System.out.printf(message, firstAnimal, secondAnimal);

        return new Scanner(System.in).nextLine().replaceFirst("[!?]", ".");
    }

    public static String answer() {
        return new Scanner(System.in).nextLine().trim().replaceFirst("[.!?]", "").toLowerCase();
    }

    public static String answer(String question) {
        System.out.println(question);
        return answer();
    }

    private static Matcher getMatcher(String fact) {
        final String regex = "It (can|has|is)";

        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        return pattern.matcher(fact);
    }
}
