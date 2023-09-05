package com.ht.tracker.workout_history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ht.tracker.user.User;
import com.ht.tracker.utils.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "workout_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkoutHistory extends BaseModel {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User user;

  @Column(name = "name", length = 200)
  private String name;

  @Column(name = "note")
  private String note;

  @Column(name = "steps")
  private Long steps;

  @Column(name = "created_date")
  private Date createdDate;
}
