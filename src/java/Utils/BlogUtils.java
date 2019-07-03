package Utils;

import Models.*;
import Views.*;
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
				String timestampStr = String.format("%s %d", MONTH_TO_STRING[p.getDc().getMonth()], p.getDc().getYear() + 1990);
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
