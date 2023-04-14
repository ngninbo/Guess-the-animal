package animals.service;

import animals.command.Command;
import animals.command.CommandFactory;
import animals.domain.*;
import animals.utils.GuessInput;

public class GuessingGame extends GameSession {

    private final NodeService nodeService;

    public GuessingGame(NodeService nodeService) {
        super();
        this.nodeService = nodeService;
    }

    @Override
    public void greet() {
        String key = String.format("greeting.%s.text", GreetFactory.of().name().toLowerCase());
        printMessage(key);
    }

    public boolean load() {
        return nodeService.loadRoot();
    }

    public void init() {

        if (!load()) {
            printMessage("guess.game.session.start.text");
            String favoriteAnimal = GuessInput.requestInput(getMessage("guess.game.session.favorite.animal.request.text"));
            nodeService.add(ArticleFactory.addUndefinedArticle(favoriteAnimal));
        }

        printMessage("guess.game.session.menu.welcome.display");
        printMessage("guess.game.session.menu.display");
    }

    public MenuItem displayMenu() {
        return new GuessingGameMenu().show();
    }

    @Override
    public boolean execute(MenuItem menuItem) {

        Command command = new CommandFactory(nodeService).from(menuItem);

        if (command == null) {
            return true;
        }

        return command.execute();
    }
}
