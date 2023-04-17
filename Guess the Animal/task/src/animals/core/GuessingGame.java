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

    protected String getMessage(String key) {
        return MessageRessource.getInstance().getProperty(key);
    }

    public void printMessage(String key) {
        System.out.println(getMessage(key));
    }
}
