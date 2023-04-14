package animals.model;

import animals.domain.Direction;

public class BinaryTree {

    private Node root;

    {
        root = new Node();
    }

    public BinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(String value) {
        root = addRecursive(root, value);
    }

    public void addAnimal(Node node, final String statement, final String animal, Direction direction) {
        final Node newAnimal = new Node(animal);
        final Node oldAnimal = new Node(node.getValue());

        boolean isRight = Direction.RIGHT.equals(direction);

        node.setValue(statement);
        node.setRight(isRight ? newAnimal : oldAnimal);
        node.setLeft(isRight ? oldAnimal : newAnimal);
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
