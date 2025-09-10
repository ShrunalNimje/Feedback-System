package com.mymood.feedbacksystem.Feedback.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.UserRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.UserResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.UserService;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {

	@Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO request) {
        UserResponseDTO saved = userService.createUser(request);
        return ResponseEntity.ok("User created successfully with id = " + saved.getUserId());
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/username/{username}")
    public UserResponseDTO getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping()
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserRequestDTO update) {
        userService.updateUser(userId, update);
        return ResponseEntity.ok("User updated successfully with id = " + userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully with id = " + userId);
    }
}
