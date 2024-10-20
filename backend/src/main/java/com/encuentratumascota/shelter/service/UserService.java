package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.User;
import com.encuentratumascota.shelter.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public Optional<User> saveUser(User user) {
        return Optional.of(iUserRepository.save(user));
    }

    @Override
    public void editUser(Long id, User user) {
        iUserRepository.save(user);
    }

}
