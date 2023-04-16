package animals;

import animals.core.GuessGameApplication;
import animals.domain.FileFormat;
import animals.domain.TreeLoader;
import animals.core.GuessingGame;
import animals.service.NodeServiceImpl;

public class Main {

    public static void main(String[] args) {

        FileFormat format = args.length < 1 ? FileFormat.JSON : FileFormat.of(args[1]);
        new GuessGameApplication(new GuessingGame(new NodeServiceImpl(TreeLoader.of(format)))).run();
    }
}
