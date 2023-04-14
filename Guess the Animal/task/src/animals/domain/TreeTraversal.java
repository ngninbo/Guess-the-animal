package animals.domain;

import animals.model.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public abstract class TreeTraversal {

    public abstract boolean hasAncestors(Node node, String target, Stack<String> ancestors);

    public void traversePreOrder(Node node, int depth, List<Integer> leafDepths) {
        if (node.isLeaf()) {
            leafDepths.add(depth);
        } else {
            traversePreOrder(node.getRight(), depth + 1, leafDepths);
            traversePreOrder(node.getLeft(), depth + 1, leafDepths);
        }
    }

    public List<Node> traverseLevelOrder(Node node) {
        List<Node> nodes = new LinkedList<>();
        traverseLevelOrder(node, nodes);
        return nodes;
    }

    private void traverseLevelOrder(Node node, List<Node> nodes) {
        if (node != null) {
            nodes.add(node);

            traverseLevelOrder(node.getLeft(), nodes);
            traverseLevelOrder(node.getRight(), nodes);
        }
    }

    public void traversePreOrder(Node node, List<String> animals) {

        if (node.isLeaf()) {
            animals.add(node.getValue());
        } else {
            traversePreOrder(node.getLeft(), animals);
            traversePreOrder(node.getRight(), animals);
        }
    }

    public int minDepth(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.isLeaf()) {
            return 1;
        }

        if (node.getLeft() == null) {
            return minDepth(node.getRight()) + 1;
        }

        if (node.getRight() == null) {
            return minDepth(node.getLeft()) + 1;
        }

        return Math.min(minDepth(node.getLeft()), minDepth(node.getRight()));
    }
}
