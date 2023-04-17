package animals.core;

public class GuessingGameApplication implements Runnable {

    private final GameSession gameSession;

    public GuessingGameApplication(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    @Override
    public void run() {
        gameSession.start();
    }
}
