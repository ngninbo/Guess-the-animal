package animals.ressource;

public interface MessageFormatter {

    default String format(String msgKey, Object... values) {
        return MessageRessource.getInstance().format(msgKey, values).concat("\n");
    }
}
