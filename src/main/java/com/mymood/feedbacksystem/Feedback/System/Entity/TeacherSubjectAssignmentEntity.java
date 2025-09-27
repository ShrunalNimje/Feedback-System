package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_subject_assignment")
public class TeacherSubjectAssignmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherSubjectAssignmentId;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private TeacherEntity teacher;
	
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
	private SubjectEntity subject;
	
	@ManyToOne
	@JoinColumn(name = "section_id", nullable = false)
	private SectionEntity section;
	
	@ManyToOne
	@JoinColumn(name = "batch_id", nullable = true)
	private BatchEntity batch;
	
	@Column(nullable = false)
	private Integer semester;
	
	public TeacherSubjectAssignmentEntity() {
		
	}

	public TeacherSubjectAssignmentEntity(Long teacherSubjectAssignmentId, TeacherEntity teacher, SubjectEntity subject, 
			Integer semester, SectionEntity section, BatchEntity batch) {
		super();
		this.teacherSubjectAssignmentId = teacherSubjectAssignmentId;
		this.teacher = teacher;
		this.subject = subject;
		this.semester = semester;
		this.section = section;
		this.batch = batch;
	}
	
	public Long getTeacherSubjectAssignmentId() {
		return teacherSubjectAssignmentId;
	}

	public void setTeacherSubjectAssignmentId(Long teacherSubjectAssignmentId) {
		this.teacherSubjectAssignmentId = teacherSubjectAssignmentId;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public SectionEntity getSection() {
		return section;
	}

	public void setSection(SectionEntity section) {
		this.section = section;
	}

	public BatchEntity getBatch() {
		return batch;
	}

	public void setBatch(BatchEntity batch) {
		this.batch = batch;
	}

}
