package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.LoginRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Request.UserRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.LoginResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.UserResponseDTO;

public interface UserService {

	UserResponseDTO createUser(UserRequestDTO create);
    UserResponseDTO getUserById(Long id);
    UserResponseDTO getUserByUsername(String username);
    List<UserResponseDTO> getAllUser();
    UserResponseDTO updateUser(Long id, UserRequestDTO update);
    void deleteUser(Long id);
    LoginResponseDTO authenticate(LoginRequestDTO request);

}
