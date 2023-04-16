package animals.domain;

import animals.ressource.MessageRessource;

public enum MenuItem {

    PLAY,
    LIST,
    SEARCH,
    //DELETE,
    STATISTICS,
    PRINT,
    EXIT,
    UNKNOWN;

    public static MenuItem of(int index) {

        if (index < 0 || index > MenuItem.size()) {
            System.out.printf(MessageRessource.getInstance().getProperty("guess.game.session.menu.item.error").concat("\n"), MenuItem.size() - 1);
            return MenuItem.UNKNOWN;
        } else if (index == 0) {
            return MenuItem.EXIT;
        } else {
            return values()[index - 1];
        }
    }

    public static int size() {
        return values().length;
    }

    public String getDescription() {
        return "guess.game.session.menu.item.".concat(name().toLowerCase());
    }

    public int computeMenuIndex() {
        return (ordinal() + 1) % (values().length - 1);
    }
}
