package com.momo.momotracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MomoTrackerApplicationTests {

  @Test
  void contextLoads() {
    SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
    Calendar cal = Calendar.getInstance();
    int weekNumber = cal.get(Calendar.WEEK_OF_YEAR);
    cal.set(Calendar.WEEK_OF_YEAR, weekNumber);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    new Date(cal.getTimeInMillis());
    System.out.println(sdf.format(cal.getTime()));
  }

}
