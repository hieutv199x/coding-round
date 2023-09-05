package com.ht.tracker.utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {
  public static Date firstDayOfWeek(Integer week) {
    Calendar cal = createCalendarWeek(week);

    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    return new Date(cal.getTimeInMillis());
  }

  public static Date firstDayOfNextWeek(Integer week) {
    Calendar cal = createCalendarWeek(week);

    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    cal.add(Calendar.WEEK_OF_YEAR, 1);
    return new Date(cal.getTimeInMillis());
  }

  public static Date firstDayOfMonth(Integer month) {
    Calendar cal = createCalendarMonth(month);

    cal.set(Calendar.DAY_OF_MONTH, 1);

    return new Date(cal.getTimeInMillis());
  }

  public static Date firstDayOfNextMonth(Integer month) {
    Calendar cal = createCalendarMonth(month);

    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.add(Calendar.MONTH, 1);

    return new Date(cal.getTimeInMillis());
  }

  private static Calendar createCalendarWeek(Integer week) {
    Calendar cal = Calendar.getInstance();

    if (week != 0) {
      cal.set(Calendar.WEEK_OF_YEAR, week);
    }

    cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);
    return cal;
  }

  private static Calendar createCalendarMonth(Integer month) {
    Calendar cal = Calendar.getInstance();

    if (month != 0) {
      cal.set(Calendar.MONTH, month);
    }

    cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
    cal.clear(Calendar.MINUTE);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MILLISECOND);
    return cal;
  }
}
