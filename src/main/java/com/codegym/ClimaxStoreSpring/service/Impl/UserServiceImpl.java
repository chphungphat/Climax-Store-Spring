package com.codegym.ClimaxStoreSpring.service.Impl;

import com.codegym.ClimaxStoreSpring.entity.user.User;
import com.codegym.ClimaxStoreSpring.repository.UserRepository;
import com.codegym.ClimaxStoreSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

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
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) throws EntityNotFoundException {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        } else {
            user.setId(id);
            return userRepository.save(user);
        }
    }

    @Override
    public void remove(Long id) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        } else {
            userRepository.delete(user.get());
        }
    }

    @Override
    public User findByUserName(String userName) throws EntityNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        } else {
            return user.get();
        }
    }
}
