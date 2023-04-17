package animals.core;

import animals.domain.MenuItem;
import animals.ressource.MessageRessource;

public abstract class GameSession implements Runnable {

    abstract void init();
    abstract boolean load();
    abstract void greet();
    abstract MenuItem displayMenu();
    abstract boolean execute(MenuItem menuItem);

    protected MenuItem menuItem = MenuItem.UNKNOWN;
    private final MessageRessource messageRessource = MessageRessource.getInstance();

    public void start() {
        greet();

        init();

        while (execute(menuItem)) {
            menuItem = displayMenu();
        }
    }

    protected String getMessage(String key) {
        return messageRessource.getProperty(key);
    }

    public void printMessage(String key) {
        System.out.println(getMessage(key));
    }

    @Override
    public void run() {
        start();
    }
}
