package animals.command;

import animals.service.NodeService;

public class PrintCommand implements Command {

    private final NodeService nodeService;

    public PrintCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {
        this.nodeService.printTree();
        return true;
    }
}
