package animals.command;

import animals.domain.ArticleFactory;
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
        String animal = GuessInput.requestInput(getMessage("guess.game.session.menu.item.search.query.enter.request"));
        printFact(ArticleFactory.addUndefinedArticle(animal));
        return true;
    }

    private void printFact(String animal) {
        Stack<String> facts = nodeService.findAllFacts(animal);
        animal = ArticleFactory.removeAll(animal);
        if (facts.isEmpty()) {
            System.out.printf(getMessage("guess.game.session.animal.fact.empty"), animal);
            return;
        }

        printResults(animal, facts);
    }

    private void printResults(String animal, Stack<String> facts) {
        System.out.printf(getMessage("guess.game.session.animal.fact"), animal);
        while (!facts.isEmpty()) {
            System.out.printf(" - %s%n", facts.pop());
        }
    }
}
