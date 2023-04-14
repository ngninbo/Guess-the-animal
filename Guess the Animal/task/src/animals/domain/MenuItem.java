package animals.domain;

public enum MenuItem {

    PLAY,
    LIST,
    SEARCH,
    STATISTICS,
    PRINT,
    EXIT,
    UNKNOWN;

    public static MenuItem of(int index) {

        if (index < 0 || index > MenuItem.size()) {
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
