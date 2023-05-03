package animals.domain;

import animals.ressource.MessageRessource;
import animals.ressource.PatternRessource;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MenuItem {

    PLAY,
    LIST,
    SEARCH,
    //DELETE,
    STATISTICS,
    PRINT,
    EXIT,
    UNKNOWN;

    public static MenuItem from(int index) {

        int length = MenuItem.values().length;

        if (index < 0 || index > length) {
            System.out.println(MessageRessource.getInstance().format("guess.game.session.menu.item.error", length - 1));
            return MenuItem.UNKNOWN;
        } else if (index == 0) {
            return MenuItem.EXIT;
        } else {
            return values()[index - 1];
        }
    }

    public String getDescription() {
        return "guess.game.session.menu.item.".concat(name().toLowerCase());
    }

    public int getIndex() {
        return (ordinal() + 1) % (values().length - 1);
    }

    public static List<String> getItems() {
        return Arrays.stream(MenuItem.values())
                .filter(menuItem -> !MenuItem.UNKNOWN.equals(menuItem))
                .map(MenuItem::format)
                .collect(Collectors.toList());
    }

    private String format() {
        return MessageFormat.format(PatternRessource.getInstance().get("menu.print.pattern"),
                getIndex(), MessageRessource.getInstance().getProperty(getDescription()));
    }
}
