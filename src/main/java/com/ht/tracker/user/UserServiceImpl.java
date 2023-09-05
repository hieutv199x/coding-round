package com.ht.tracker.user;

import com.ht.tracker.utils.BaseServiceImpl;
import com.ht.tracker.utils.Utils;
import com.ht.tracker.workout_history.WorkoutHistoryRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserRepository, User> implements UserService {

  private final WorkoutHistoryRepository workoutHistoryRepository;

  public UserServiceImpl(UserRepository repository,
      WorkoutHistoryRepository workoutHistoryRepository) {
    this.repository = repository;
    this.workoutHistoryRepository = workoutHistoryRepository;
  }

  @Override
  public List<UserDTO> leaderBoard(Integer limit, Integer offset) {
    List<UserDTO> rs = new ArrayList<>();
    Pageable sortedByStepsDesc =
        PageRequest.of(offset, limit, Sort.by("steps").descending());
    var objectList = repository.getLeaderBoardsNative(sortedByStepsDesc);
    for (Object[] obj : objectList) {
      Long id = (Long) obj[0];
      String name = (String) obj[1];
      String phoneNumber = (String) obj[2];
      BigDecimal steps = (BigDecimal) obj[3];
      var userDto = new UserDTO(id, name, phoneNumber, steps);
      rs.add(userDto);
    }
    return rs;
  }

  @Override
  public Long getStepsOnWeek(Long userId) {
    var startDate = Utils.firstDayOfWeek(0);
    var endDate = Utils.firstDayOfNextWeek(0);

    return workoutHistoryRepository.getSteps(startDate, endDate, userId);
  }

  @Override
  public Long getStepsOnMonth(Long userId) {
    var startDate = Utils.firstDayOfMonth(0);
    var endDate = Utils.firstDayOfNextMonth(0);

    return workoutHistoryRepository.getSteps(startDate, endDate, userId);
  }
}