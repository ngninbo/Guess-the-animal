package animals.service;

import animals.domain.NodePath;
import animals.model.Node;
import animals.model.TreeStats;

import java.util.List;
import java.util.Stack;

public interface NodeService {

    void add(String value);

    void update(Node node, String statement, Node child, NodePath nodePath);

    boolean loadRoot();

    void saveRoot();

    List<String> findAllAnimals();

    Node getRoot();

    Stack<String> findAllFacts(String animal);

    TreeStats statistics();

    boolean delete(String animal);
}
