package animals.domain;

import animals.model.Node;

public enum NodeType {

    ROOT,
    CHILD;

    public static NodeType of(Node node) {
        return node.isLeaf() ? CHILD : ROOT;
    }

    public boolean isLeaf() {
        return CHILD.equals(this);
    }
}
