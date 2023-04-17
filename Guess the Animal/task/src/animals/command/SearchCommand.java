package animals.command;

import animals.factories.ArticleFactory;
import animals.service.NodeService;
import animals.utils.GuessInput;

import java.util.Stack;

public class SearchCommand implements Command {

    private final NodeService nodeService;

    public SearchCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {
        String animal = GuessInput.requestInput(format("guess.game.session.animal.prompt"));
        printFact(ArticleFactory.addUndefinedArticle(animal));
        return true;
    }

    private void printFact(String animal) {
        Stack<String> facts = nodeService.findAllFacts(animal);
        animal = ArticleFactory.removeAll(animal);
        if (facts.isEmpty()) {
            System.out.print(format("guess.game.session.tree.search.noFacts", animal));
            return;
        }

        printResults(animal, facts);
    }

    private void printResults(String animal, Stack<String> facts) {
        System.out.print(format("guess.game.session.tree.search.facts", animal));
        while (!facts.isEmpty()) {
            System.out.print(format("guess.game.session.tree.search.printf", facts.pop()));
        }
    }
}
