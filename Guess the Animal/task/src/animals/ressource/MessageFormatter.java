package animals.ressource;

public abstract class MessageFormatter {

    public static String format(String msgKey, Object... values) {
        return MessageRessource.getInstance().format(msgKey, values).concat("\n");
    }
}
