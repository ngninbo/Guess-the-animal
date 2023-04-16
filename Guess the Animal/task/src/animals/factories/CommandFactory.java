package animals.factories;

import animals.command.*;
import animals.domain.MenuItem;
import animals.service.NodeService;
import animals.ressource.MessageRessource;

public class CommandFactory {

    private final NodeService nodeService;

    public CommandFactory(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public Command from(MenuItem menuItem) {

        switch (menuItem) {
            case PLAY:
                return new PlayCommand(nodeService);
            case LIST:
                //printChoice(menuItem);
                return new ListCommand(nodeService);
            case SEARCH:
                //printChoice(menuItem);
                return new SearchCommand(nodeService);
//            case DELETE:
//                return new DeleteCommand(nodeService);
            case STATISTICS:
                return new StatisticCommand(nodeService);
            case PRINT:
                return new PrintCommand(nodeService);
            case EXIT:
                return new ExitCommand(nodeService);
            default:
                //throw new IllegalArgumentException("Unknown command");
        }

        return null;
    }

    private void printChoice(MenuItem menuItem) {
        System.out.println(MessageRessource.getInstance().getProperty("guess.game.session.menu.item.choice"));
        System.out.println(menuItem.ordinal() + 1);
    }
}
