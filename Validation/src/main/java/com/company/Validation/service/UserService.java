package com.company.Validation.service;

import com.company.Validation.dto.UserRequest;
import com.company.Validation.entity.User;
import com.company.Validation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(UserRequest request) {

        User user = new  User(0, request.getName(), request.getEmail(), request.getMobile(), request.getGender(), request.getAge(), request.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}
