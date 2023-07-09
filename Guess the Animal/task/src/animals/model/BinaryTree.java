package animals.model;

import animals.domain.Direction;
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
