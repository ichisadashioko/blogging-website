package Utils;

import java.util.*;

public class BlogUtils {

	public static String formatDate(Date d) {
		int year = d.getYear() + 1990;
		int month = d.getMonth() + 1;
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		String suffix;
		if (hours > 12) {
			hours %= 12;
			suffix = "PM";
		} else {
			suffix = "AM";
		}
		String retval = String.format("%d-%02d-%02d %02d:%02d %s", year, month, date, hours, minutes, suffix);
		return retval;
	}

	public static String formatSQLDate(Date d) {
		int year = d.getYear() + 1990;
		int month = d.getMonth() + 1;
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
        int sec = d.getSeconds();
		String retval = String.format("%04d%02d%02d %02d:%02d:%02d", year, month, date, hours, minutes, sec);
		return retval;
	}
}
