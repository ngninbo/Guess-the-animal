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
        printStatistics();
        return true;
    }

    private void printStatistics() {
        System.out.println(getMessage("guess.game.session.statistics.header").concat("\n"));
        TreeStats stats = nodeService.statistics();
        System.out.println(stats);
    }
}
