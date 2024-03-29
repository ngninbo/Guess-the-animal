package animals.domain;

import animals.factories.ArticleFactory;
import animals.factories.ObjectMapperFactory;
import animals.model.BinaryTree;
import animals.model.Node;
import animals.model.Statement;
import animals.model.TreeStats;
import animals.repository.NodeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TreeLoader extends TreeTraversal implements NodeRepository {

    private final ObjectMapper objectMapper;

    private final String filename;

    private TreeLoader(FileFormat format) {
        this.objectMapper = ObjectMapperFactory.of(format);
        String language = Locale.getDefault().getLanguage();
        this.filename = "animals" + ("en".equals(language) ? "." : "_" + language + ".").concat(format.toString());
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

        return TreeStats.builder()
                .root(root.getValue())
                .nodes(sizeOf(traverseLevelOrder(root)))
                .statements(sizeOf(findStatements(root)))
                .animals(sizeOf(findLeafNodes(root)))
                .height(stats.getMax())
                .minDepth(minDepth(root))
                .avgDepth(round(stats.getAverage()))
                .build();
    }

    @Override
    public void update(BinaryTree tree, Node node, String value, Node child, NodePath nodePath) {
        tree.addChild(node, value, child, nodePath);
    }

    @Override
    public void loadRoot(BinaryTree tree) throws IOException {
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
    public boolean remove(String animal, BinaryTree tree) {

        if (containsNodeRecursive(tree.getRoot(), animal)) {
            deleteRecursive(tree.getRoot(), animal);
            return true;
        }

        return false;
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
}
