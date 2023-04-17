package animals.factories;

import animals.domain.Greet;
import animals.ressource.MessageRessource;

import java.time.LocalTime;

public class GreetFactory {
    
    private static final MessageRessource MESSAGE_RESSOURCE = MessageRessource.getInstance();

    public static Greet of() {
        return of(LocalTime.now());
    }

    public static Greet of(LocalTime time) {

        Greet greet = null;
        if (isMorning(time)) {
            greet = Greet.MORNING;
        } else if (isAfternoon(time)) {
            greet = Greet.AFTERNOON;
        } else if (isEvening(time)) {
            greet = Greet.EVENING;
        } else if (isNightOwl(time)) {
            greet = Greet.NIGHT_OWL;
        } else if (isEarlyBird(time)) {
            greet = Greet.EARLY_BIRD;
        }

        return greet;
    }

    private static boolean isEarlyBird(LocalTime time) {
        LocalTime earlyStart = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.early.time.start"));
        LocalTime earlyEnd = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.early.time.end"));
        return time.isAfter(earlyStart) && time.isBefore(earlyEnd);
    }

    private static boolean isNightOwl(LocalTime time) {
        LocalTime nightStart = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.night.time.start"));
        LocalTime nightEnd = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.night.time.end"));
        return time.isAfter(nightStart) && time.isBefore(nightEnd);
    }

    private static boolean isEvening(LocalTime time) {
        LocalTime eveningStart = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.evening.time.start"));
        return time.isAfter(eveningStart);
    }

    private static boolean isMorning(LocalTime time) {
        LocalTime morningStart = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.morning.time.start"));
        LocalTime morningEnd = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.morning.time.end"));
        return time.isAfter(morningStart) && time.isBefore(morningEnd);
    }
    
    private static boolean isAfternoon(LocalTime time) {
        LocalTime afternoonEnd = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.afternoon.time.end"));
        LocalTime afternoonStart = LocalTime.parse(MESSAGE_RESSOURCE.getProperty("guess.game.session.afternoon.time.start"));
        return time.isAfter(afternoonStart) && time.isBefore(afternoonEnd);
    }
}
