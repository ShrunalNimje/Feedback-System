package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.UserEntity;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Repository.BatchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.UserRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public StudentResponseDTO createStudent(StudentRequestDTO create) {
		
		BatchEntity batch = batchRepository.findById(create.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found!"));

		UserEntity user = new UserEntity();
		user.setPassword(passwordEncoder.encode(create.getPassword()));
		user.setUsername(create.getUsername());
		user.setRole(Role.STUDENT);
		userRepository.save(user);
		
        StudentEntity student = new StudentEntity();
        student.setName(create.getName());
        student.setRollNo(create.getRollNo()); 
        student.setEmail(create.getEmail());
        student.setBatch(batch);
        student.setEnrollmentId(create.getEnrollmentId());
        student.setUser(user);
        student.setAttendancePercentage(create.getAttendance());
        student.setSection(batch.getSection());
        student.setBranch(batch.getSection().getBranch());
        student.setDepartment(batch.getSection().getBranch().getDepartment());
        student.setSemester(create.getSemester());
        student.setYear(create.getYear());
        
        StudentEntity saved = studentRepository.save(student);
        
        return new StudentResponseDTO(
        		saved.getStudentId(),
        		saved.getName(),
        		saved.getRollNo(),
        		saved.getEmail(),
        		saved.getBatch().getName(),
        		saved.getUser().getUsername(),
        		saved.getEnrollmentId()
        );
	}

	@Override
	public StudentResponseDTO getStudent(Long id) {
		
		StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        
		return new StudentResponseDTO(
				student.getStudentId(),
				student.getName(),
				student.getRollNo(),
				student.getEmail(),
        		student.getBatch().getName(),
        		student.getUser().getUsername(),
        		student.getEnrollmentId()
        );
	}

	@Override
	public List<StudentResponseDTO> getAllStudent() {

		return studentRepository.findAll().stream()
                .map(student -> new StudentResponseDTO(
        				student.getStudentId(),
        				student.getName(),
        				student.getRollNo(),
        				student.getEmail(),
                		student.getBatch().getName(),
                		student.getUser().getUsername(),
                		student.getEnrollmentId()
                ))
                .collect(Collectors.toList());
	}

	@Override
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO update) {
		
		StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
		
		if(update.getName() != null) {
			student.setName(update.getName());
		}
		
		if(update.getRollNo() != null) {
			student.setRollNo(update.getRollNo());
		}
		
		if(update.getEmail() != null) {
	        student.setEmail(update.getEmail());
		}
		
		if(update.getBatchId() != null) {
			BatchEntity batch = batchRepository.findById(update.getBatchId())
	                .orElseThrow(() -> new RuntimeException("Batch not found!"));
			
	        student.setBatch(batch);
		}

        StudentEntity saved = studentRepository.save(student);

        return new StudentResponseDTO(
        		saved.getStudentId(),
        		saved.getName(),
        		saved.getRollNo(),
        		saved.getEmail(),
        		saved.getBatch().getName(),
        		saved.getUser().getUsername(),
        		saved.getEnrollmentId()
        );
	}

	@Override
	public void deleteStudent(Long id) {
		
		studentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Student not found!"));
		
		studentRepository.deleteById(id);
	}

}
