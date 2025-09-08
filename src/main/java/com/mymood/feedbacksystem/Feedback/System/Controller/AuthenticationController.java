package com.mymood.feedbacksystem.Feedback.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.LoginRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.LoginResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Service.UserService;

@RestController
public class AuthenticationController {

	@Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
    	LoginResponseDTO token = userService.authenticate(request);
        return ResponseEntity.ok(token);
    }
}
