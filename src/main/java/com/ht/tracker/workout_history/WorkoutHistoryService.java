package com.ht.tracker.workout_history;

import com.ht.tracker.utils.BaseService;
import java.util.Date;

public interface WorkoutHistoryService extends BaseService<WorkoutHistory, Long> {

  /**
   * Find workout history by created date
   * @param createdDate created date
   * @return workout history
   */
  WorkoutHistory findByCreatedDate(Date createdDate);
}
