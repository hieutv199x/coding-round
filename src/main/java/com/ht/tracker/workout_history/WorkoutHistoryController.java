package com.ht.tracker.workout_history;

import com.ht.tracker.user.UserService;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workout-history")
@RequiredArgsConstructor
@Slf4j
public class WorkoutHistoryController {

  private final WorkoutHistoryService workoutHistoryService;
  private final UserService userService;

  /**
   * 1. API ghi nhận số bước chân trong ngày hiện tại từ phía ứng dụng
   * @param dto data transfer object from client
   * @return result
   */
  @PostMapping
  public ResponseEntity<?> save(@RequestBody WorkoutHistoryDTO dto) {
    try {
      var user = userService.get(dto.getUserId());
      if (user == null) {
        log.warn("Can't found user: {}", dto.getUserId());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exists!");
      }

      // Check record on the same day
      var createdDate = dto.getCreatedDate() != null ? dto.getCreatedDate() : new Date();
      var workoutHistory = workoutHistoryService.findByCreatedDate(createdDate);

      if (workoutHistory != null) {
        log.warn("Can't save workout history on the same day: {}", dto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("In a day, you can't create 2 workout histories");
      }
      else {
        workoutHistory = new WorkoutHistory();
      }
      workoutHistory.setCreatedDate(createdDate);
      workoutHistory.setUser(user);
      workoutHistory.setName(dto.getName());
      workoutHistory.setNote(dto.getNote());
      workoutHistory.setSteps(dto.getSteps());

      var res = workoutHistoryService.save(workoutHistory);
      if (res == null) {
        log.warn("Can't save workout: {}", dto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't save your workout!");
      }
      return ResponseEntity.ok(res);
    } catch (Exception ex) {
      log.error("Can't save workout", ex);
      throw ex;
    }
  }
}
