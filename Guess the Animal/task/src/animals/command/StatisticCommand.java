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
        System.out.println(getMessage("guess.game.session.statistics.title").concat("\n"));
        TreeStats stats = nodeService.statistics();

        var out = new StringBuilder();

        out
                .append(String.format(getMessage("guess.game.session.statistics.root").concat("%n"), stats.getRoot()))
                .append(String.format(getMessage("guess.game.session.statistics.nodes").concat("%n"), stats.getNodes()))
                .append(String.format(getMessage("guess.game.session.statistics.animals").concat("%n"), stats.getAnimals()))
                .append(String.format(getMessage("guess.game.session.statistics.statements").concat("%n"), stats.getStatements()))
                .append(String.format(getMessage("guess.game.session.statistics.height").concat("%n"), stats.getHeight()))
                .append(String.format(getMessage("guess.game.session.statistics.minimum").concat("%n"), stats.getMinDepth()))
                .append(String.format(getMessage("guess.game.session.statistics.average").concat("%n"), stats.getAvgDepth()));


        System.out.printf("%s", out);
    }
}
