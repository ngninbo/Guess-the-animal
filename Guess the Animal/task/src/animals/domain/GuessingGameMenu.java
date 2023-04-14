package animals.domain;

import animals.utils.MessageRessource;

import java.util.Arrays;
import java.util.Scanner;

public class GuessingGameMenu {

    public MenuItem show() {
        return MenuItem.of(requestOption());
    }

    public int requestOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        Arrays.stream(MenuItem.values())
                .filter(menuItem -> !MenuItem.UNKNOWN.equals(menuItem))
                .forEach(menuItem -> {
                    final String description = getProperty(menuItem.getDescription());
                    System.out.printf("%s. %s%n", menuItem.computeMenuIndex(), description);
                });

        return scanner.nextInt();
    }

    private String getProperty(String key) {
        return MessageRessource.getInstance().getProperty(key);
    }
}
