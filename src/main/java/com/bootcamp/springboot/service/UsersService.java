package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    public UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findByUsername(String username) {
        return this.usersRepository.findByUsername(username);
    }

    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    public void save(Users users) {
        usersRepository.save(users);
    }

    public Users update(Users users) {
        return usersRepository.save(users);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
