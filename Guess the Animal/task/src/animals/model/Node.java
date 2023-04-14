package animals.model;

import animals.domain.ArticleFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {

    private String value;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @JsonIgnore
    public boolean isLeaf() {
        return left == null && right == null;
    }

    @JsonIgnore
    public String Info() {
        final String fact = getValue().replaceFirst("It|it\\s", "").trim();
        Statement statement = new Statement(fact);
        return String.format("%s\n%s", getFormat(getRight(), statement.getText()), getFormat(getLeft(), statement.negate()));
    }

    @JsonIgnore
    private String getFormat(Node leaf, String fact) {
        return String.format("- The %s %s", ArticleFactory.removeAll(leaf.getValue()).trim(),
                fact.endsWith(".") ? fact : fact.concat("."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getValue(), node.getValue()) && Objects.equals(getLeft(), node.getLeft()) &&
                Objects.equals(getRight(), node.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getLeft(), getRight());
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
