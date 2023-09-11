package animals.command;

import animals.domain.GuessGameValidator;
import animals.factories.ArticleFactory;
import animals.service.NodeService;
import animals.utils.GuessInput;

public class DeleteCommand extends Command {

    public DeleteCommand(NodeService nodeService) {
        super(nodeService);
    }

    @Override
    public GuessState execute() {

        String animal = getAnimal();

        if (animal.equals(nodeService.getRoot().getValue())) {
            System.out.println(format("guess.game.session.tree.delete.root"));
        } else if (nodeService.delete(animal)) {
            System.out.println(format("guess.game.session.tree.delete.successful", ArticleFactory.removeAll(animal)));
        } else {
            System.out.println(format("guess.game.session.tree.delete.fail", ArticleFactory.removeAll(animal)));
        }

        return state;
    }

    private String getAnimal() {

        String animal = GuessInput.requestInput(format("guess.game.session.animal.prompt"));

        while(!GuessGameValidator.getInstance().matches("animal.1.pattern", animal)) {
            System.out.println(format("guess.game.session.animal.error"));
            animal = GuessInput.requestInput();
        }

        return animal;
    }
}
