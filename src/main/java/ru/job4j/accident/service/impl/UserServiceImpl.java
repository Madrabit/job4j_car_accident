package ru.job4j.accident.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserRepository;
import ru.job4j.accident.service.UserService;

/**
 * @author madrabit on 06.10.2020
 * @version 1$
 * @since 0.1
 */
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
