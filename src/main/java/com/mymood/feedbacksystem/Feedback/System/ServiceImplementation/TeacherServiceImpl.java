package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.UserEntity;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.UserRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public TeacherResponseDTO createTeacher(TeacherRequestDTO create) {
		
		DepartmentEntity department = departmentRepository.findById(create.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found!"));

		UserEntity user = new UserEntity();
		user.setPassword(passwordEncoder.encode(create.getPassword()));
		user.setUsername(create.getUsername());
		user.setRole(Role.TEACHER);
		userRepository.save(user);
		
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName(create.getName());
        teacher.setEmail(create.getEmail());
        teacher.setDepartment(department);
        teacher.setUser(user);

        TeacherEntity saved = teacherRepository.save(teacher);
        return new TeacherResponseDTO(saved.getTeacherId(), saved.getName(), saved.getEmail(), 
        		saved.getDepartment().getName(), saved.getUser().getUsername());
	}

	@Override
	public TeacherResponseDTO getTeacher(Long id) {
		
		TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));
		
        return new TeacherResponseDTO(teacher.getTeacherId(), teacher.getName(), teacher.getEmail(), 
        		teacher.getDepartment().getName(), teacher.getUser().getUsername());
	}

	@Override
	public List<TeacherResponseDTO> getAllTeacher() {
		
		return teacherRepository.findAll()
                .stream()
                .map(teacher -> new TeacherResponseDTO(
                		teacher.getTeacherId(),
                        teacher.getName(),
                        teacher.getEmail(),
                        teacher.getDepartment().getName(),
                        teacher.getUser().getUsername()))
                .collect(Collectors.toList());
	}

	@Override
	public TeacherResponseDTO updateTeacher(Long id, TeacherRequestDTO update) {
		
		TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));

		if(update.getName() != null) {
			teacher.setName(update.getName());
		}
        
		if(update.getEmail() != null) {
	        teacher.setEmail(update.getEmail());
		}
		
		if(update.getDepartmentId() != null) {
			DepartmentEntity department = departmentRepository.findById(update.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found!"));
	        
	        teacher.setDepartment(department);		
        }

        TeacherEntity saved = teacherRepository.save(teacher);
        
        return new TeacherResponseDTO(saved.getTeacherId(), saved.getName(), saved.getEmail(), 
        		saved.getDepartment().getName(), saved.getUser().getUsername());
	}

	@Override
	public void deleteTeacher(Long id) {

		teacherRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Teacher not found!"));
		
		teacherRepository.deleteById(id);
	}

}
