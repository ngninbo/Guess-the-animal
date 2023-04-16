package animals.command;

import animals.domain.GuessGameValidator;
import animals.factories.ArticleFactory;
import animals.service.NodeService;
import animals.utils.GuessInput;

public class DeleteCommand implements Command {

    private final NodeService nodeService;

    public DeleteCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {

        String animal = getAnimal();

        if (animal.equals(nodeService.getRoot().getValue())) {
            System.out.println(getMessage("guess.game.session.tree.delete.root"));
        } else if (nodeService.delete(animal)) {
            System.out.printf(getMessage("guess.game.session.tree.delete.successful").concat("%n"), ArticleFactory.removeAll(animal));
        } else {
            System.out.printf(getMessage("guess.game.session.tree.delete.fail").concat("%n"), ArticleFactory.removeAll(animal));
        }

        return true;
    }

    private String getAnimal() {

        String animal = GuessInput.requestInput(getMessage("guess.game.session.animal.prompt"));

        while(!GuessGameValidator.getInstance().matches("animal.1.pattern", animal)) {
            System.out.println(getMessage("guess.game.session.animal.error"));
            animal = GuessInput.requestInput();
        }

        return animal;
    }
}
