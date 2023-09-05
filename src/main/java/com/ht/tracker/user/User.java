package com.ht.tracker.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ht.tracker.utils.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseModel {

  @Column(name = "name" , length = 100)
  private String name;

  @Column(name = "dob")
  private Date dob;

  @Column(name = "phone_number", length = 15)
  private String phoneNumber;

  @Transient
  private Long steps;
}
