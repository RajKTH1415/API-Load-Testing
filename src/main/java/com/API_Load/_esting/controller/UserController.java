package com.API_Load._esting.controller;

import com.API_Load._esting.entity.User;
import com.API_Load._esting.response.ApiResponse;
import com.API_Load._esting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "User created successfully", savedUser));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse<>(true, "Users fetched successfully", users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(new ApiResponse<>(true, "User fetched successfully", user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "User not found", null)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails)
                .map(user -> ResponseEntity.ok(new ApiResponse<>(true, "User updated successfully", user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "User not found", null)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok(new ApiResponse<>(true, "User deleted successfully", null));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "User not found", null));
        }
    }
}
