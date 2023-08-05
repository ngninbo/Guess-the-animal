package animals.command;

import animals.domain.NodeType;
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
        print(root, "", NodeType.of(root));
    }

    private void print(Node node, String prefix, NodeType nodeType) {
        if (node != null) {
            System.out.println(prefix + (nodeType.isLeaf() ? "├─ " : "└─ ") + (node.isLeaf() ? node.getValue() : QuestionFactory.from(node.getValue())));
            print(node.getRight(), prefix + (nodeType.isLeaf() ? "│   " : "    "), NodeType.CHILD);
            print(node.getLeft(), prefix + (nodeType.isLeaf() ? "│   " : "    "), NodeType.ROOT);
        }
    }
}
