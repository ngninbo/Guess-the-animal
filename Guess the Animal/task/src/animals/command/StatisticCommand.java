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
        System.out.println(format("guess.game.session.statistics.title"));

        String out = format("guess.game.session.statistics.overview", stats.getRoot(), stats.getNodes(),
                stats.getAnimals(), stats.getStatements(), stats.getHeight(), stats.getMinDepth(), stats.getAvgDepth());

        System.out.print(out);
    }
}
