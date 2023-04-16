package animals.core;

public class GuessGameApplication implements Runnable {

    private final GameSession gameSession;

    public GuessGameApplication(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    @Override
    public void run() {
        gameSession.start();
    }
}
