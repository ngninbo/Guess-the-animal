package animals;

import animals.domain.FileFormat;
import animals.domain.TreeLoader;
import animals.core.GuessingGameApplication;
import animals.service.NodeServiceImpl;

public class Main {

    public static void main(String[] args) {

        FileFormat format = args.length < 1 ? FileFormat.JSON : FileFormat.of(args[1]);
        new GuessingGameApplication(new NodeServiceImpl(TreeLoader.of(format))).run();
    }
}
