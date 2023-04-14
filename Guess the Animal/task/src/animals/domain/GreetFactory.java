package animals.domain;

import java.time.LocalTime;

public class GreetFactory {

    public static Greet of() {
        LocalTime time = LocalTime.now();
        LocalTime beginOfDay = LocalTime.parse("05:00:00");
        LocalTime eob = LocalTime.parse("18:00:00");
        Greet greet = null;
        if (time.isAfter(beginOfDay) && time.isBefore(LocalTime.NOON)) {
            greet = Greet.MORNING;
        } else if (time.isAfter(LocalTime.NOON) && time.isBefore(eob)) {
            greet = Greet.AFTERNOON;
        } else if (time.isAfter(eob)) {
            greet = Greet.EVENING;
        } else if (time.isAfter(LocalTime.MIDNIGHT) && time.isBefore(beginOfDay)) {
            greet = Greet.NIGHT_OWL;
        } else if (time.isAfter(beginOfDay) && time.getHour() < 9) {
            greet = Greet.EARLY_BIRD;
        }

        return greet;
    }
}
