package hello;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateDiff {
	
	public static long years(Date d1, Date d2) { 
		long milliseconds1 = d1.getTime();
		long milliseconds2 = d2.getTime();
		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		long diffMinutes = diffSeconds / 60;
		long diffHours = diffMinutes / 60;
		long diffDays = diffHours / 24;
		long diffYears = (long)(Math.floor(diffDays / 365));
		return diffYears;
	}
	
	public static void main(String[] args) {
		/** The date at the end of 1980 */
		Date d1 = new GregorianCalendar(1979, 11, 31, 23, 59).getTime();

		/** Today's date */
		Date d2 = new Date();
		System.out.println("Years since " + d1 +": " + DateDiff.years(d1,d2));
	}

}
