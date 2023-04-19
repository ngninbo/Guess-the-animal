package animals.command;

import animals.model.TreeStats;
import animals.service.NodeService;

public class StatisticCommand implements Command {

    private final NodeService nodeService;

    public StatisticCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {
        printStatistics(nodeService.statistics());
        return true;
    }

    private void printStatistics(TreeStats stats) {
        System.out.print(format("guess.game.session.statistics.title"));

        String out = format("guess.game.session.statistics.root", stats.getRoot()) +
                format("guess.game.session.statistics.nodes", stats.getNodes()) +
                format("guess.game.session.statistics.animals", stats.getAnimals()) +
                format("guess.game.session.statistics.statements", stats.getStatements()) +
                format("guess.game.session.statistics.height", stats.getHeight()) +
                format("guess.game.session.statistics.minimum", stats.getMinDepth()) +
                format("guess.game.session.statistics.average", stats.getAvgDepth());


        System.out.println(out);
    }
}
