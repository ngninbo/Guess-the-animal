package animals.domain;

public enum NodePath {

    LEFT,
    RIGHT;

    public boolean isRightPath() {
        return NodePath.RIGHT.equals(this);
    }
}
