package animals.command;

import animals.domain.*;
import animals.factories.ArticleFactory;
import animals.factories.QuestionFactory;
import animals.model.Node;
import animals.core.Game;
import animals.service.NodeService;
import animals.utils.GuessInput;

public class PlayCommand implements Command, Game {

    private final NodeService nodeService;
    private final GuessGameValidator validator = GuessGameValidator.getInstance();
    private Node current;

    public PlayCommand(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public boolean execute() {

        do {
            guess();
        } while (playAgain());

        System.out.println(new RandomItem<>(getMessage("guess.game.session.thanks").split("\f")).next());

        return true;
    }

    @Override
    public void guess() {
        String input = GuessInput.requestInput(getMessage("guess.game.session.instruction.text"));
        this.current = nodeService.getRoot();
        if (input.isBlank()) {

            if (isGuessed()) {
                System.out.println(getMessage("guess.game.session.guessing.correct.text"));
            } else {
                addAnimal();
            }
        }
    }

    public boolean playAgain() {
        return validator.isPositivResponse()
                .test(GuessInput.answer(new RandomItem<>(getMessage("guess.game.session.play.again.text").split("\f")).next()));
    }

    public void addAnimal() {
        String animal = ArticleFactory.addUndefinedArticle(GuessInput.requestInput(getMessage("guess.game.session.animal.in.mind.request.text")));

        String sentence = GuessInput.requestFact(current.getValue(), animal).replaceFirst("[!?]", ".");

        String answer = getAnswer(QuestionFactory.verify(animal));

        Direction direction = validator.isPositivResponse().test(answer) ? Direction.RIGHT : Direction.LEFT;
        addAnimal(current, sentence, animal, direction);

        String question = QuestionFactory.from(sentence);

        System.out.printf(getMessage("guess.game.session.facts.learned.text").concat("\n"), current.Info(), question);
        System.out.println(new RandomItem<>(getMessage("guess.game.session.animal.nice").split("\f")).next()
                .concat(getMessage("guess.game.session.learning.finished.text")));
    }

    public void addAnimal(Node node, final String statement, final String animal, Direction direction) {
        nodeService.addAnimal(node, statement, animal, direction);
    }

    public boolean isGuessed() {
        return validator.isPositivResponse().test(askQuestion(nodeService.getRoot()));
    }

    private String askQuestion(Node node) {

        if (node.isLeaf()) {
            this.current = node;
            return getAnswer(QuestionFactory.from(node.getValue()).trim());
        } else {
            boolean answer = validator.isPositivResponse().test(getAnswer(QuestionFactory.from(node.getValue())));

            return answer ? askQuestion(node.getRight()) : askQuestion(node.getLeft());
        }
    }

    public String getAnswer(String question) {

        String answer = GuessInput.answer(question);

        while (validator.isPositivOrNegativeResponse().negate().test(answer)) {
            answer = GuessInput.answer(new RandomItem<>(getMessage("guess.game.session.ask.again").split("\f")).next());
        }

        return answer;
    }
}
