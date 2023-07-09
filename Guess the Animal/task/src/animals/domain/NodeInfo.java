package animals.domain;

import animals.factories.ArticleFactory;
import animals.model.Node;
import animals.model.Statement;
import animals.ressource.PatternRessource;

import java.text.MessageFormat;

public class NodeInfo {

    private static final PatternRessource PATTERN_RESSOURCE = PatternRessource.getInstance();

    public static String of(Node node) {
        final String fact = node.getValue().replaceFirst(PATTERN_RESSOURCE.get("statement_replace.pattern"), "").trim();
        Statement statement = new Statement(fact);

        return getFormat(node.getRight(), fact).concat("\n") + getFormat(node.getLeft(), statement.negate());
    }

    private static String getFormat(Node leaf, String fact) {
        return MessageFormat.format(PATTERN_RESSOURCE.get("animals.facts.print.pattern"), ArticleFactory.removeAll(leaf.getValue()).trim(),
                fact.endsWith(".") ? fact : fact.concat("."));
    }
}
