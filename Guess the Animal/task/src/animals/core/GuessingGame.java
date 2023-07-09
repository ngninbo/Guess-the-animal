package animals.core;

import animals.domain.MenuItem;
import animals.ressource.MessageRessource;

public abstract class GuessingGame {

    abstract void init();
    abstract boolean load();
    abstract void greet();
    abstract MenuItem displayMenu();
    abstract boolean execute(MenuItem menuItem);

    protected MenuItem menuItem = MenuItem.UNKNOWN;

    public void start() {
        greet();

        init();

        while (execute(menuItem)) {
            menuItem = displayMenu();
        }
    }

    protected String getMessage(String key, Object... args) {
        return MessageRessource.getInstance().format(key, args);
    }

    public void printMessage(String key, Object... args) {
        System.out.println(getMessage(key, args));
    }
}
