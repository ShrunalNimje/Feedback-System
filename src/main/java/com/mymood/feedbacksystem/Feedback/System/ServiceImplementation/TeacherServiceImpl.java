package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public TeacherResponseDTO createTeacher(TeacherRequestDTO create) {
		
		DepartmentEntity department = departmentRepository.findById(create.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found!"));

        TeacherEntity teacher = new TeacherEntity();
        teacher.setName(create.getName());
        teacher.setEmail(create.getEmail());
        teacher.setDepartment(department);

        TeacherEntity saved = teacherRepository.save(teacher);
        return new TeacherResponseDTO(saved.getTeacherId(), saved.getName(), saved.getEmail(), saved.getDepartment().getName());
	}

	@Override
	public TeacherResponseDTO getTeacher(Long id) {
		
		TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));
		
        return new TeacherResponseDTO(teacher.getTeacherId(), teacher.getName(), teacher.getEmail(), teacher.getDepartment().getName());
	}

	@Override
	public List<TeacherResponseDTO> getAllTeacher() {
		
		return teacherRepository.findAll()
                .stream()
                .map(teacher -> new TeacherResponseDTO(
                		teacher.getTeacherId(),
                        teacher.getName(),
                        teacher.getEmail(),
                        teacher.getDepartment().getName()))
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
        
        return new TeacherResponseDTO(saved.getTeacherId(), saved.getName(), saved.getEmail(), saved.getDepartment().getName());
	}

	@Override
	public void deleteTeacher(Long id) {

		teacherRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Teacher not found!"));
		
		teacherRepository.deleteById(id);
	}

}
