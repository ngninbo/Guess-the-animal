package animals.command;

import animals.service.NodeService;

public class ListCommand extends Command {

    public ListCommand(NodeService nodeService) {
        super(nodeService);
    }

    @Override
    public GuessState execute() {
        System.out.print(format("guess.game.session.menu.list.result"));
        nodeService.findAllAnimals()
                .forEach(value -> System.out.print(format("guess.game.session.tree.search.printf", value)));
        return state;
    }
}
