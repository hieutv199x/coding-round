package com.ht.tracker.user;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "select u.id, u.name, u.phone_number as phoneNumber, sum(wh.steps) as steps"
      + " from user u "
      + " inner join workout_history wh"
      + " on u.id = wh.user_id"
      + " group by u.id", nativeQuery = true)
  List<Object[]> getLeaderBoardsNative(Pageable pageable);
}
