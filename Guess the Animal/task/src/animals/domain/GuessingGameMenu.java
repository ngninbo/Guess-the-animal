package animals.domain;

import animals.ressource.MessageRessource;
import animals.ressource.PatternRessource;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;

public class GuessingGameMenu {

    public MenuItem show() {
        return MenuItem.of(requestOption());
    }

    public int requestOption() {
        Scanner scanner = new Scanner(System.in);
        displayOptions();

        return scanner.nextInt();
    }

    private void displayOptions() {
        System.out.println();
        Arrays.stream(MenuItem.values())
                .filter(menuItem -> !MenuItem.UNKNOWN.equals(menuItem))
                .forEach(this::print);
    }

    private String getProperty(String key) {
        return MessageRessource.getInstance().getProperty(key);
    }

    private void print(MenuItem menuItem) {
        final String description = getProperty(menuItem.getDescription());
        System.out.println(MessageFormat.format(PatternRessource.getInstance().get("menu.print.pattern"),
                menuItem.computeMenuIndex(), description));
    }
}
