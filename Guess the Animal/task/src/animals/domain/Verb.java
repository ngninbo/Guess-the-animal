package animals.domain;

public enum Verb {

    HAS,
    IS,
    CAN;

    public String getNegation() {
        return getMessageKey("guess.game.session.negation.verb");
    }

    public String getInterrogation() {
        return getMessageKey("guess.game.session.interrogation.verb");
    }

    private String getMessageKey(String key) {
        return String.format("%s.%s", key, name().toLowerCase());
    }
}
