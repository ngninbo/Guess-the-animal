package animals.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum FileFormat {

    JSON,
    XML,
    YAML;

    public static FileFormat of(String type) {
        return isValidType().test(type) ? FileFormat.valueOf(type.toUpperCase()) : FileFormat.JSON;
    }

    private static Predicate<String> isValidType() {
        return type -> Arrays.stream(values()).anyMatch(format -> type.equalsIgnoreCase(format.name()));
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
