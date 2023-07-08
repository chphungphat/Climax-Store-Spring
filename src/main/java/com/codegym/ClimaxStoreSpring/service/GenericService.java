package com.codegym.ClimaxStoreSpring.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(T t);

    Optional<T> update(T t, Long id);
}
