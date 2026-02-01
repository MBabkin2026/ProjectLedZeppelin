package com.javarush.babkin.repository;


import com.javarush.babkin.QuestProgress;
import com.javarush.babkin.entity.Role;
import com.javarush.babkin.entity.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());


    public UserRepository() {
        map.put(1L, User.builder()
                .id(1L)
                .login("ZZTop")
                .password("12345")
                .role(Role.ADMIN)
                .questProgress(new QuestProgress())
                .build());

        map.put(2L, User.builder()
                .id(2L)
                .login("Aerosmith")
                .password("qwert")
                .role(Role.USER)
                .questProgress(new QuestProgress())
                .build());

        map.put(3L, User.builder()
                .id(3L)
                .login("Ramones")
                .password("asdf")
                .role(Role.GUEST)
                .questProgress(new QuestProgress())
                .build());
    }



    @Override
    public Collection<User> getAll() {
        return map.values();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.getId());
    }
}