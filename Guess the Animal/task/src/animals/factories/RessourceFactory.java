package animals.factories;

import java.util.Locale;
import java.util.ResourceBundle;

public class RessourceFactory {

    public static ResourceBundle of(String name) {

        Locale locale = Locale.getDefault();
        if ("eo".equalsIgnoreCase(locale.getLanguage())) {
            return of(name, locale);
        }

        return ResourceBundle.getBundle(name);
    }

    public static ResourceBundle of(String name, Locale locale) {
        return ResourceBundle.getBundle(name, locale);
    }

    public static ResourceBundle of(String name, String language) {
        return ResourceBundle.getBundle(String.format("%s_%s", name, language));
    }
}
