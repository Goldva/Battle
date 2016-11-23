package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateHelper {
    private GregorianCalendar beganeBattle;
    private GregorianCalendar endBattle;

    public DateHelper() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+4"));
        beganeBattle = new GregorianCalendar();
        beganeBattle.add(Calendar.YEAR, -1500);
        endBattle = new GregorianCalendar();
        endBattle.add(Calendar.YEAR, -1500);
    }

    public String getFormattedStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyy HH:mm");
        return dateFormat.format(beganeBattle.getTime());
    }

    public void skipTime() {
        endBattle.add(Calendar.MINUTE, 45);
    }

    public String getFormattedDiff() {
        long millisecond = endBattle.getTime().getTime() - beganeBattle.getTime().getTime();
        long minutes = (millisecond / (1000 * 60)) % 60;
        long hours = (millisecond / (1000 * 60 * 60)) % 24;
        long days = (millisecond / (1000 * 60 * 60 * 24)) % 365;
        long years = (millisecond / (1000 * 60 * 60 * 24)) / 365;
        String format = "Продолжительность битвы ";
        String yearsText = "%d год(а, лет), ";
        String daysText = "%d дней(день, дня), ";
        String hoursText = "%d час(ов), ";
        String minutesText = "%d мынут(у)";
        if (years != 0)
            return String.format(format + yearsText + daysText + hoursText + minutesText, years, days, hours, minutes);
        if (days != 0)
            return String.format(format + daysText + hoursText + minutesText, days, hours, minutes);
        if (hours != 0)
            return String.format(format + hoursText + minutesText, hours, minutes);
        else
            return String.format(format + minutesText, minutes);


    }
}
