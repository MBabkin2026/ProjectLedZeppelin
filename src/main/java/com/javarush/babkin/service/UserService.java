package com.javarush.babkin.service;


import com.javarush.babkin.QuestProgress;
import com.javarush.babkin.entity.User;
import com.javarush.babkin.repository.Repository;
import com.javarush.babkin.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public enum UserService {
    USER_SERVICE;

    public final Repository<User> userRepository = new UserRepository();

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getById(long id) {
        return userRepository.get(id);
    }

    public User getUserById(long userId) {
        return userRepository.get(userId).orElse(null);
    }

    public void updateQuestProgress(Long userId, QuestProgress progress) {
        userRepository.get(userId).ifPresent(user -> {
            user.setQuestProgress(progress);
            userRepository.update(user);
        });
    }

    public QuestProgress getQuestProgress(Long userId) {
        return userRepository.get(userId)
                .map(User::getQuestProgress)
                .orElse(new QuestProgress());
    }
}
