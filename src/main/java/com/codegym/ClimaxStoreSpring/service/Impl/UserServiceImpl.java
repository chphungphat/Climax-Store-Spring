package com.codegym.ClimaxStoreSpring.service.Impl;

import com.codegym.ClimaxStoreSpring.entity.user.User;
import com.codegym.ClimaxStoreSpring.repository.UserRepository;
import com.codegym.ClimaxStoreSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public Optional<User> update(User user, Long id) {
        return userRepository.s;
    }
}
