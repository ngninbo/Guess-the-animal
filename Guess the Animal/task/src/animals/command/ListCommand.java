package animals.command;

import animals.service.NodeService;

public class ListCommand implements Command {

    private final NodeService nodeService;

    public ListCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {
        System.out.println(getMessage("guess.game.session.menu.list.result"));
        nodeService.findAllAnimals()
                .forEach(value -> System.out.printf(getMessage("guess.game.session.tree.search.printf"), value));
        return true;
    }
}
