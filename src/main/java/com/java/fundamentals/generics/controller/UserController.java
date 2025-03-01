package com.java.fundamentals.generics.controller;

import com.java.fundamentals.generics.dto.UserDTO;
import com.java.fundamentals.generics.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> findById(Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO>  addUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/userListByIds")
    public ResponseEntity<List<UserDTO>> findByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(userService.findByIds(ids));
    }

}
