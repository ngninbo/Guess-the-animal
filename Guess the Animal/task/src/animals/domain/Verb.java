package animals.domain;

public enum Verb {

    TO_BE,
    TO_HAVE,
    TO_CAN;

    public String getValue() {
        return getMessageKey("verb");
    }

    public String getNegation() {
        return getMessageKey("negation.verb");
    }

    public String getInterrogation() {
        return getMessageKey("interrogation.verb");
    }

    private String getMessageKey(String key) {
        return String.format("%s.%s", key, name().toLowerCase());
    }
}
