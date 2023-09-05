package com.ht.tracker.workout_history;

import com.ht.tracker.utils.BaseServiceImpl;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class WorkoutHistoryServiceImpl extends
    BaseServiceImpl<WorkoutHistoryRepository, WorkoutHistory> implements WorkoutHistoryService {

  public WorkoutHistoryServiceImpl(WorkoutHistoryRepository repository) {
    this.repository = repository;
  }

  @Override
  public WorkoutHistory findByCreatedDate(Date createdDate) {
    return repository.findWorkoutHistoryByCreatedDate(createdDate);
  }
}
