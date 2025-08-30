package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.BatchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public StudentResponseDTO createStudent(StudentRequestDTO create) {
		
		BatchEntity batch = batchRepository.findById(create.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found!"));

        StudentEntity student = new StudentEntity();
        student.setName(create.getName());
        student.setEnrollmentId(create.getRollNo()); 
        student.setEmail(create.getEmail());
        student.setBatch(batch);

        StudentEntity saved = studentRepository.save(student);
        
        return new StudentResponseDTO(
        		saved.getStudentId(),
        		saved.getName(),
        		saved.getEnrollmentId(),
        		saved.getEmail(),
        		saved.getBatch().getName()
        );
	}

	@Override
	public StudentResponseDTO getStudent(Long id) {
		
		StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        
		return new StudentResponseDTO(
                student.getStudentId(),
                student.getName(),
                student.getEnrollmentId(),
                student.getEmail(),
                student.getBatch().getName()
        );
	}

	@Override
	public List<StudentResponseDTO> getAllStudent() {

		return studentRepository.findAll().stream()
                .map(student -> new StudentResponseDTO(
                        student.getStudentId(),
                        student.getName(),
                        student.getEnrollmentId(),
                        student.getEmail(),
                        student.getBatch().getName()
                ))
                .collect(Collectors.toList());
	}

	@Override
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO update) {
		
		StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        BatchEntity batch = batchRepository.findById(update.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found!"));

        student.setName(update.getName());
        student.setEnrollmentId(update.getRollNo());
        student.setEmail(update.getEmail());
        student.setBatch(batch);

        StudentEntity saved = studentRepository.save(student);

        return new StudentResponseDTO(
        		saved.getStudentId(),
        		saved.getName(),
        		saved.getEnrollmentId(),
        		saved.getEmail(),
        		saved.getBatch().getName()
        );
	}

	@Override
	public void deleteStudent(Long id) {
		
		studentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Student not found!"));
		
		studentRepository.deleteById(id);
	}

}
