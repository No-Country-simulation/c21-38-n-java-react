package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> findUsers();
    public Optional<User> getUser(Long id);
    public Optional<User> saveUser(User user);
    public void editUser(Long id, User user);
}
