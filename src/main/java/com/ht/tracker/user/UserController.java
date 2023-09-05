package com.ht.tracker.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  /**
   * 2. API lấy bảng xếp hạng để hiển thị ở ứng dụng
   * @param limit Limit record will be returned
   * @param offset Offset of record
   * @return Leader boards
   */
  @GetMapping(path = "/leaderboards")
  public ResponseEntity<List<UserDTO>> getLeaderBoards(
      @RequestParam(name = "limit", defaultValue = "10") Integer limit,
      @RequestParam(name = "offset", defaultValue = "0") Integer offset) {
    //TODO Add feature communicate with cache system
    return ResponseEntity.ok(userService.leaderBoard(limit, offset));
  }

  /**
   * 3. API lấy tổng số bước chân của người dùng theo tuần hiện tại để hiển thị ở ứng dụng
   * @param userId trong truong hop chay that se su dung user id tu thong tin authentication
   * @return workout history of user
   */
  @GetMapping(path = "/workout-history/week/{userId}")
  public ResponseEntity<?> getWorkoutHistoryByWeek(@PathVariable Long userId) {
    var user = userService.get(userId);
    if (user == null) {
      log.warn("Can't found user: {}", userId);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exists!");
    }
    //TODO Add feature communicate with cache system
    return ResponseEntity.ok(userService.getStepsOnWeek(userId));
  }

  /**
   * 4. API lấy tổng số bước chân của người dùng theo tháng hiện tại để hiển thị ở ứng dụng
   * @param userId trong truong hop chay that se su dung user id tu thong tin authentication
   * @return workout history of user
   */
  @GetMapping(path = "/workout-history/month/{userId}")
  public ResponseEntity<?> getWorkoutHistoryByMonth(@PathVariable Long userId) {
    var user = userService.get(userId);
    if (user == null) {
      log.warn("Can't found user: {}", userId);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exists!");
    }
    //TODO Add feature communicate with cache system
    return ResponseEntity.ok(userService.getStepsOnMonth(userId));
  }
}
