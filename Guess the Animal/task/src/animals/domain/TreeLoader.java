package animals.domain;

import animals.model.BinaryTree;
import animals.model.Node;
import animals.model.Statement;
import animals.model.TreeStats;
import animals.repository.NodeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TreeLoader extends TreeTraversal implements NodeRepository {

    private final ObjectMapper objectMapper;

    private final String filename;

    private TreeLoader(FileFormat format) {
        this.objectMapper = getObjectMapper(format);
        this.filename = "animals.".concat(format.name().toLowerCase());
    }

    public static NodeRepository of(FileFormat format) {
        return new TreeLoader(format);
    }

    public Node load() throws IOException {
        return objectMapper.readValue(new File(filename), Node.class);
    }

    public void save(BinaryTree tree) throws IOException {
        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File(filename), tree.getRoot());

    }

    @Override
    public List<String> findLeafNodes(Node root) {
        List<String> animals = new ArrayList<>();
        traversePreOrder(root, animals);
        return animals.stream()
                .map(ArticleFactory::removeAll)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    @Override
    public TreeStats summary(BinaryTree tree) {
        Node root = tree.getRoot();
        List<Integer> depths = new LinkedList<>();
        traversePreOrder(root, 0, depths);
        var stats = depths.stream().collect(Collectors.summarizingInt(Integer::intValue));

        return TreeStats.TreeStatsBuilder.init()
                .withRoot(root.getValue())
                .withNodes(traverseLevelOrder(root).size())
                .withStatements(findStatements(root).size())
                .withAnimals(findLeafNodes(root).size())
                .withHeight(stats.getMax())
                .withMinDepth(minDepth(root))
                .withAvgDepth(stats.getAverage())
                .build();
    }

    @Override
    public void update(BinaryTree tree, Node node, String statement, String animal, Direction direction) {
        tree.addAnimal(node, statement, animal, direction);
    }

    @Override
    public void setRoot(BinaryTree tree) throws IOException {
        tree.setRoot(load());
    }

    @Override
    public List<String> findStatements(Node root) {
        return traverseLevelOrder(root)
                .stream()
                .filter(node -> !node.isLeaf())
                .map(Node::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Stack<String> findAncestors(BinaryTree tree, String value) {

        Stack<String> pathToValue = new Stack<>();

        if (hasAncestors(tree.getRoot(), value, pathToValue)) {
            return pathToValue;
        }

        return new Stack<>();
    }

    @Override
    public boolean hasAncestors(Node node, String target, Stack<String> ancestors) {
        /* base cases */
        if (node == null)
            return false;

        if (target.equals(node.getValue())) {
            return true;
        }

        if (hasAncestors(node.getLeft(), target, ancestors)) {
            ancestors.addElement(new Statement(node.getValue()).negate());
            return true;
        }

        if (hasAncestors(node.getRight(), target, ancestors)) {
            ancestors.addElement(node.getValue());
            return true;
        }

        return false;

    }

    private ObjectMapper getObjectMapper(FileFormat format) {
        switch (format) {
            case XML:
                return new XmlMapper();
            case YAML:
                return new YAMLMapper();
            default:
                return new JsonMapper();
        }
    }
}
