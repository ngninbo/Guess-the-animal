package animals.command;

import animals.factories.QuestionFactory;
import animals.model.Node;
import animals.service.NodeService;

public class PrintCommand implements Command {

    private final NodeService nodeService;

    public PrintCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {
        print(nodeService.getRoot());
        return true;
    }

    private void print(Node root) {
        print(root, "", root.isLeaf());
    }

    private void print(Node node, String prefix, boolean isLeaf) {
        if (node != null) {
            System.out.println(prefix + (isLeaf ? "├─ " : "└─ ") + (node.isLeaf() ? node.getValue() : QuestionFactory.from(node.getValue())));
            print(node.getRight(), prefix + (isLeaf ? "│   " : "    "), true);
            print(node.getLeft(), prefix + (isLeaf ? "│   " : "    "), false);
        }
    }
}
