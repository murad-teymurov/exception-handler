package com.company.Validation.controller;

import com.company.Validation.dto.UserRequest;
import com.company.Validation.entity.User;
import com.company.Validation.exception.UserNotFoundException;
import com.company.Validation.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException {
        User user = userService.getUserById(id);

        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            throw new UserNotFoundException(" User Not found!");
        }
//        return ResponseEntity.ok(userService.getUserById(id));
    }


}
