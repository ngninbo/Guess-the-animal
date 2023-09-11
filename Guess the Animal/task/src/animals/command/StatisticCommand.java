package animals.command;

import animals.model.TreeStats;
import animals.service.NodeService;

public class StatisticCommand extends Command {

    public StatisticCommand(NodeService nodeService) {
        super(nodeService);
    }

    @Override
    public GuessState execute() {
        printStatistics(nodeService.statistics());
        return state;
    }

    private void printStatistics(TreeStats stats) {
        System.out.println(format("guess.game.session.statistics.title"));

        String out = format("guess.game.session.statistics.overview", stats.getRoot(), stats.getNodes(),
                stats.getAnimals(), stats.getStatements(), stats.getHeight(), stats.getMinDepth(), stats.getAvgDepth());

        System.out.print(out);
    }
}
