package com.ht.tracker.utils;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseServiceImpl<R extends JpaRepository<T, Long>, T extends BaseModel> implements
    BaseService<T, Long> {
  protected R repository;

  @Override
  public T get(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public T save(T data) {
    return repository.save(data);
  }
}
