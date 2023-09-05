package com.ht.tracker.workout_history;

import java.util.Date;
import lombok.Data;

@Data
public class WorkoutHistoryDTO {

  private Long id;
  private String name;
  private String note;
  private Long steps;
  private Date createdDate;
  private Long userId;
}
