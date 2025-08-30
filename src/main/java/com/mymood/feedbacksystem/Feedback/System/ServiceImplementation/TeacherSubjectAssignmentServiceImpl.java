package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.TeacherSubjectAssignmentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectAssignmentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SubjectEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherSubjectAssignmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.BatchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SectionRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SubjectRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherSubjectAssignmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.TeacherSubjectAssignmentService;

public class TeacherSubjectAssignmentServiceImpl implements TeacherSubjectAssignmentService{

	@Autowired
	TeacherSubjectAssignmentRepository teacherSubjectAssignmentRepository;
    
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
    SubjectRepository subjectRepository;
	
	@Autowired
    SectionRepository sectionRepository;
	
	@Autowired
    BatchRepository batchRepository;
	
	@Override
	public TeacherSubjectAssignmentResponseDTO createAssignment(TeacherSubjectAssignmentRequestDTO create) {
		
		TeacherEntity teacher = teacherRepository.findById(create.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));
		
        SubjectEntity subject = subjectRepository.findById(create.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found!"));
        
        SectionEntity section = sectionRepository.findById(create.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section not found!"));
        
        BatchEntity batch = batchRepository.findById(create.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found!"));

        TeacherSubjectAssignmentEntity assignment = new TeacherSubjectAssignmentEntity();
        assignment.setTeacher(teacher);
        assignment.setSubject(subject);
        assignment.setSection(section);
        assignment.setBatch(batch);
        assignment.setYear(create.getYear());
        assignment.setSemester(create.getSemester());

        TeacherSubjectAssignmentEntity saved = teacherSubjectAssignmentRepository.save(assignment);

        return new TeacherSubjectAssignmentResponseDTO(
                saved.getTeacherSubjectAssignmentId(),
                saved.getTeacher().getTeacherId(),
                saved.getSubject().getSubjectId(),
                saved.getSection().getSectionId(),
                saved.getBatch().getBatchId(),
                saved.getYear(),
                saved.getSemester());
	}

	@Override
	public TeacherSubjectAssignmentResponseDTO getAssignment(Long id) {

		TeacherSubjectAssignmentEntity assignment = teacherSubjectAssignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));

		return new TeacherSubjectAssignmentResponseDTO(
				assignment.getTeacherSubjectAssignmentId(),
				assignment.getTeacher().getTeacherId(),
				assignment.getSubject().getSubjectId(),
				assignment.getSection().getSectionId(),
				assignment.getBatch().getBatchId(),
				assignment.getYear(),
				assignment.getSemester());
	}

	@Override
	public List<TeacherSubjectAssignmentResponseDTO> getAllAssignment() {

		return teacherSubjectAssignmentRepository.findAll()
                .stream()
                .map(assignment -> new TeacherSubjectAssignmentResponseDTO(
                		assignment.getTeacherSubjectAssignmentId(),
        				assignment.getTeacher().getTeacherId(),
        				assignment.getSubject().getSubjectId(),
        				assignment.getSection().getSectionId(),
        				assignment.getBatch().getBatchId(),
        				assignment.getYear(),
        				assignment.getSemester()))
                .collect(Collectors.toList());
	}

	@Override
	public TeacherSubjectAssignmentResponseDTO updateAssignment(Long id, TeacherSubjectAssignmentRequestDTO update) {

		TeacherSubjectAssignmentEntity assignment = teacherSubjectAssignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found!"));

        TeacherEntity teacher = teacherRepository.findById(update.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));
        
        SubjectEntity subject = subjectRepository.findById(update.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found!"));
        
        SectionEntity section = sectionRepository.findById(update.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section not found!"));
        
        BatchEntity batch = batchRepository.findById(update.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found!"));

        assignment.setTeacher(teacher);
        assignment.setSubject(subject);
        assignment.setSection(section);
        assignment.setBatch(batch);
        assignment.setYear(update.getYear());
        assignment.setSemester(update.getSemester());

        TeacherSubjectAssignmentEntity updated = teacherSubjectAssignmentRepository.save(assignment);

        return new TeacherSubjectAssignmentResponseDTO(
        		updated.getTeacherSubjectAssignmentId(),
        		updated.getTeacher().getTeacherId(),
        		updated.getSubject().getSubjectId(),
        		updated.getSection().getSectionId(),
        		updated.getBatch().getBatchId(),
        		updated.getYear(),
        		updated.getSemester());
	}

	@Override
	public void deleteAssignment(Long id) {

		teacherSubjectAssignmentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Assignment not found!"));

		teacherSubjectAssignmentRepository.deleteById(id);
	}

}
