package animals.utils;

import animals.domain.GuessGameValidator;
import animals.ressource.MessageRessource;

import java.util.Arrays;
import java.util.Scanner;

public class GuessInput {

    public static String requestInput(String... messages) {
        Arrays.stream(messages).forEach(System.out::print);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public static String requestFact(String firstAnimal, String secondAnimal) {

        String fact = "";

        while (!GuessGameValidator.getInstance().matches().apply("animals.facts.correct.pattern", fact)) {
            fact = getDistinguishingFact(firstAnimal, secondAnimal);
        }

        return fact;
    }

    public static String getDistinguishingFact(String firstAnimal, String secondAnimal) {
        System.out.println(MessageRessource.getInstance().format("guess.game.session.distinguishing.fact.request.text", firstAnimal, secondAnimal));

        return new Scanner(System.in).nextLine().replaceFirst("[!?]", ".");
    }

    public static String answer() {
        return new Scanner(System.in).nextLine().trim().replaceFirst("[.!?]", "").toLowerCase();
    }

    public static String answer(String question) {
        System.out.println(question);
        return answer();
    }
}
