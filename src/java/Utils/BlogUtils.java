package Utils;

import Models.*;
import Views.*;
import java.util.*;
import java.time.*;

public class BlogUtils {

	public static String formatDate(Date d) {
		LocalDate ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = ld.getYear();
		int month = ld.getMonthValue();
		int date = ld.getDayOfMonth();
		String retval = String.format("%02d-%02d-%04d", date, month, year);
		return retval;
	}

	public static String formatDNDate(Date d) {
		LocalDate ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = ld.getYear();
		int month = ld.getMonthValue();
		int date = ld.getDayOfMonth();

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
		LocalDate ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = ld.getYear();
		int month = ld.getMonthValue();
		int date = ld.getDayOfMonth();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int sec = d.getSeconds();
		String retval = String.format("%04d%02d%02d %02d:%02d:%02d", year, month, date, hours, minutes, sec);
		return retval;
	}

	public static List<Integer> generateCounterItems(int visitorCount, int minDigits) {
		List<Integer> retval = new ArrayList<>();
		String str = Integer.toString(visitorCount);
		if (str.length() < minDigits) {
			int remainder = visitorCount;
			for (int i = 0; i < minDigits; i++) {
				retval.add(0, remainder % 10);
				remainder /= 10;
			}
		} else {
			int remainder = visitorCount;
			while (remainder > 0) {
				retval.add(0, remainder % 10);
				remainder /= 10;
			}

		}
		return retval;
	}
	public static final String[] MONTH_TO_STRING = {
		"JANUARY",
		"FEBRURY",
		"MARCH",
		"APRIL",
		"MAY",
		"JUNE",
		"JULY",
		"AUGUST",
		"SEPTEMBER",
		"OCTOBER",
		"NOVEMBER",
		"DECEMBER",};

	public static List<MonthlyEntry> filterPostList(List<Post> postList) {
		List<MonthlyEntry> retval = new ArrayList<>();
		MonthlyEntry me = null;
		List<Post> mePostList = null;
		int curDateTime = -1;
		for (int i = 0; i < postList.size(); i++) {
			Post p = postList.get(i);
			int postTimestamp = p.getDc().getYear() * 100 + p.getDc().getMonth();
			if (postTimestamp == curDateTime) {
				mePostList.add(p);
			} else {
				// set current month and year
				curDateTime = postTimestamp;
				// format
				LocalDate ld = p.getDc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				String timestampStr = String.format("%s %d", MONTH_TO_STRING[p.getDc().getMonth()], ld.getYear());
				// create new entry
				me = new MonthlyEntry();
				retval.add(me);
				// set title
				me.setTimestamp(timestampStr);
				// the post list
				mePostList = new ArrayList<Post>();
				// append the current post to the post list
				mePostList.add(p);
				me.setPostList(mePostList);
			}
		}
		return retval;
	}
}
