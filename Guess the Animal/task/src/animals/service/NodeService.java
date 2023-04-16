package animals.service;

import animals.domain.Direction;
import animals.model.Node;
import animals.model.TreeStats;

import java.util.List;
import java.util.Stack;

public interface NodeService {

    void add(String value);

    void addAnimal(Node node, final String statement, final String animal, Direction direction);

    boolean loadRoot();

    void saveRoot();

    List<String> findAllAnimals();

    void printTree();

    Node getRoot();

    Stack<String> findAllFacts(String animal);

    TreeStats statistics();

    boolean delete(String animal);
}
