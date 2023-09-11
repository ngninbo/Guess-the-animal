package animals.command;

import animals.domain.RandomItem;
import animals.service.NodeService;

public class ExitCommand extends Command {

    public ExitCommand(NodeService nodeService) {
        super(nodeService);
    }

    @Override
    public GuessState execute() {

        save();

        sayGoodbye();

        state = GuessState.TERMINATE;

        return state;
    }

    public void save() {
        nodeService.saveRoot();
    }

    public void sayGoodbye() {
        System.out.println(new RandomItem<>(format("guess.game.session.farewell").split("\f")).next());
    }
}
