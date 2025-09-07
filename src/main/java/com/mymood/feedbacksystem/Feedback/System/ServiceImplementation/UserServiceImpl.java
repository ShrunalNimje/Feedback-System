package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.UserRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.UserResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.UserEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.UserRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponseDTO createUser(UserRequestDTO create) {
		
		UserEntity user = new UserEntity();
        user.setUsername(create.getUsername());
        user.setPassword(create.getPassword());
        user.setRole(create.getRole());

        UserEntity saved = userRepository.save(user);
        return new UserResponseDTO(saved.getUserId(), saved.getUsername(), saved.getRole());
	}

	@Override
	public UserResponseDTO getUserById(Long id) {

		UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return new UserResponseDTO(user.getUserId(), user.getUsername(), user.getRole());
	}

	@Override
	public UserResponseDTO getUserByUsername(String username) {
		
		UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDTO(user.getUserId(), user.getUsername(), user.getRole());
	}

	@Override
	public List<UserResponseDTO> getAllUser() {
		
		return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getUserId(),
                        user.getUsername(),
                        user.getRole()))
                .collect(Collectors.toList());
	}

	@Override
	public UserResponseDTO updateUser(Long id, UserRequestDTO update) {
		
		UserEntity user = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found!"));

		if(update.getPassword() != null) {
		    user.setPassword(update.getPassword());
		}
		
		if(update.getRole() != null) {
		    user.setRole(update.getRole());
		}
		
		if(update.getUsername() != null) {
		    user.setUsername(update.getUsername());
		}

	    UserEntity saved = userRepository.save(user);
        return new UserResponseDTO(saved.getUserId(), saved.getUsername(), saved.getRole());
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.findById(id).orElseThrow(
				() -> new RuntimeException("User not found!"));
		
		userRepository.deleteById(id);	
	}

}
