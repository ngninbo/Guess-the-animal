package animals.repository;

import animals.domain.NodePath;
import animals.model.BinaryTree;
import animals.model.Node;
import animals.model.TreeStats;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public interface NodeRepository {

    Node load() throws IOException;

    void save(BinaryTree tree) throws IOException;

    List<String> findLeafNodes(Node node);

    TreeStats summary(BinaryTree tree);

    void update(BinaryTree tree, Node node, String value, Node child, NodePath nodePath);

    void loadRoot(BinaryTree tree) throws IOException;

    List<String> findStatements(Node node);

    Stack<String> findAncestors(BinaryTree tree, String animal);

    boolean remove(String animal, BinaryTree tree);
}
