package com.ht.tracker.workout_history;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutHistoryRepository extends JpaRepository<WorkoutHistory, Long> {
  WorkoutHistory findWorkoutHistoryByCreatedDate(Date createdDate);

  @Query("SELECT sum(wh.steps) FROM WorkoutHistory wh "
      + "where wh.createdDate >= :startDate and wh.createdDate < :endDate "
      + "and wh.user.id = :userId group by wh.user.id")
  Long getSteps(Date startDate, Date endDate, Long userId);
}
