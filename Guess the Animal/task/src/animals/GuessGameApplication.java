package animals;
import animals.service.GameSession;

public class GuessGameApplication implements Runnable {

    private final GameSession gameSession;

    public GuessGameApplication(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    protected void guess() {
        gameSession.start();
    }

    @Override
    public void run() {
        start();
    }

    private void start() {
        gameSession.start();
    }
}
