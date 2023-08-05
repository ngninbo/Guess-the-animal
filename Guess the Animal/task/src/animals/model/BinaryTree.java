package animals.model;

import animals.domain.NodePath;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class BinaryTree {

    @Getter
    @Setter
    private Node root = new Node();

    public void add(String value) {
        root = addRecursive(root, value);
    }

    public void addChild(Node node, String value, Node child, NodePath nodePath) {
        final Node oldAnimal = new Node(node.getValue());

        node.setValue(value);

        node.setRight(nodePath.isRightPath() ? child : oldAnimal);
        node.setLeft(nodePath.isRightPath() ? oldAnimal : child);
    }

    private Node addRecursive(Node current, String value) {
        if (current.getValue() == null && current.isLeaf()) {
            return new Node(value);
        }

        if (value.compareToIgnoreCase(current.getValue()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value.compareToIgnoreCase(current.getValue()) > 0) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            // value already exists
            return current;
        }

        return current;
    }
}
