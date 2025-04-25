package enums;

import java.time.*;

enum Day {
    MONTAG,
    DIENSTAG,
    MITTWOCH,
    DONERSTAG,
    FREITAG,
    SAMSTAG,
    SONNTAG;

}

enum Status {
    AKTIV, INAKTIV;

    public boolean isAktiv() {
        return this == AKTIV;
    }
}

public class WeekDay {
    Day day;

    public WeekDay(Day tag) {
        this.day = tag;
    }

    public void thisDayIsLike() {
        switch (day) {
            case MONTAG:
                System.out.println("Schlafen Tag. ");
                break;
            case FREITAG:
                System.out.println(" Feiertage sind besser");
                break;
            case SONNTAG:
                System.out.println("Wochenende ist die beste arbeitstag");
                break;
            default:
                System.out.println("Ich hasse Schule!!!");
                break;
        }
    }

    public static void main(String[] args) {

        // String str = "";
        // WeekDay t1 = new WeekDay(Day.FREITAG);
        // t1.thisDayIsLike();

        // WeekDay t2 = new WeekDay(Day.MITTWOCH);
        // t2.thisDayIsLike();

        // for (Day tag : Day.values()) {
        // System.out.println(tag);
        // }

        LocalDate heute = LocalDate.now();
        System.out.println(heute);
        DayOfWeek tag = heute.getDayOfWeek();
        System.out.println(tag);

        Status aktuellerStatus = Status.AKTIV;
        System.out.println(aktuellerStatus);

        if (aktuellerStatus.isAktiv()) {
            System.out.println("Der Status is Aktiv.");
        } else {
            System.out.println("Der Status is inaktiv.");
        }
    }
}
