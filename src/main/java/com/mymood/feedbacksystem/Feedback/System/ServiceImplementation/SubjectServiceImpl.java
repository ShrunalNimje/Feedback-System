package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SubjectRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubjectResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SubjectRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public SubjectResponseDTO createSubject(SubjectRequestDTO create) {
		
		DepartmentEntity department = departmentRepository.findById(create.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found!"));
		
		SubjectEntity subject = new SubjectEntity();
        subject.setName(create.getSubjectName());
        subject.setCode(create.getSubjectCode());
        subject.setType(create.getSubjectType()); 
        subject.setSemester(create.getSemester());
        subject.setDepartment(department);

        SubjectEntity saved = subjectRepository.save(subject);
        return new SubjectResponseDTO(saved.getSubjectId(), saved.getCode(), saved.getName(), 
        		saved.getType(), saved.getDepartment().getName());
	}

	@Override
	public SubjectResponseDTO getSubject(Long id) {
		
		SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));

        return new SubjectResponseDTO(subject.getSubjectId(), subject.getCode(), subject.getName(), 
        		subject.getType(), subject.getDepartment().getName());
	}

	@Override
	public List<SubjectResponseDTO> getAllSubject() {

		return subjectRepository.findAll().
				stream()
                .map(subject -> new SubjectResponseDTO(
                        subject.getSubjectId(),
                        subject.getName(),
                        subject.getCode(),
                        subject.getType(),
                        subject.getDepartment().getName()))
                .collect(Collectors.toList());
	}

	@Override
	public SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO update) {
		
		SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));

		if(update.getSubjectType() != null) {
	        subject.setType(update.getSubjectType()); 
		}
		
		if(update.getSubjectName() != null) {
			subject.setName(update.getSubjectName());
		}
		
		if(update.getSubjectCode() != null) {
	        subject.setCode(update.getSubjectCode());
		}
		
		if(update.getDepartmentId() != null) {
			DepartmentEntity department = departmentRepository.findById(update.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department not found!"));
			
	        subject.setDepartment(department);
		}

        SubjectEntity saved = subjectRepository.save(subject);

        return new SubjectResponseDTO(saved.getSubjectId(), saved.getCode(), saved.getName(), 
        		saved.getType(), saved.getDepartment().getName());
	}

	@Override
	public void deleteSubject(Long id) {

		subjectRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Subject not found!"));
		
		subjectRepository.deleteById(id);
	}

}
