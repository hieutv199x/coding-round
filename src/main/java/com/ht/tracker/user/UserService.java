package com.ht.tracker.user;

import com.ht.tracker.utils.BaseService;
import java.util.List;

public interface UserService extends BaseService<User, Long> {

  /**
   * Get leader boards
   * @param limit limit record
   * @param offset offset
   * @return leaderBoards with range limit, offset
   */
  List<UserDTO> leaderBoard(Integer limit, Integer offset);

  Long getStepsOnWeek(Long userId);

  Long getStepsOnMonth(Long userId);
}
