package animals.core;

import animals.command.Command;
import animals.domain.GuessingGameMenu;
import animals.domain.MenuItem;
import animals.factories.ArticleFactory;
import animals.factories.CommandFactory;
import animals.factories.GreetFactory;
import animals.service.NodeService;
import animals.utils.GuessInput;

public class GameSession extends GuessingGame {

    private final NodeService nodeService;

    public GameSession(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    protected void greet() {
        String key = String.format("guess.game.greeting.%s.text", GreetFactory.of().name().toLowerCase());
        printMessage(key);
    }

    @Override
    protected boolean load() {
        return nodeService.loadRoot();
    }

    @Override
    protected void init() {

        if (!load()) {
            printMessage("guess.game.session.start.text");
            String favoriteAnimal = GuessInput.requestInput(getMessage("guess.game.session.favorite.animal.request.text"));
            nodeService.add(ArticleFactory.addUndefinedArticle(favoriteAnimal));
        }

        printMessage("guess.game.session.menu.welcome.display");
        printMessage("guess.game.session.menu.display");
    }

    @Override
    protected MenuItem displayMenu() {
        return new GuessingGameMenu().show();
    }

    @Override
    protected boolean execute(MenuItem menuItem) {

        Command command = new CommandFactory(nodeService).from(menuItem);

        if (command == null) {
            return true;
        }

        return command.execute();
    }
}
