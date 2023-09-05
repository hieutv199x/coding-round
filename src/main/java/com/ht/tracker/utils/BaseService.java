package com.ht.tracker.utils;

public interface BaseService<T, ID> {
  T get(ID id);

  T save(T id);
}
