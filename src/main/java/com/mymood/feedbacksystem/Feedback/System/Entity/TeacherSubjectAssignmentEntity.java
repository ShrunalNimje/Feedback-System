package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_subject_assignment")
public class TeacherSubjectAssignmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teacherSubjectAssignmentId;
	
	@Column(nullable = false)
	private TeacherEntity teacher;
	
	@Column(nullable = false)
	private SubjectEntity subject;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Integer semester;
	
	@Column(nullable = false)
	private SectionEntity section;
	
	@Column(nullable = false)
	private BatchEntity batch;
	
	public TeacherSubjectAssignmentEntity() {
		
	}

	public TeacherSubjectAssignmentEntity(Long teacherSubjectAssignmentId, TeacherEntity teacher, SubjectEntity subject,
			Integer year, Integer semester, SectionEntity section, BatchEntity batch) {
		super();
		this.teacherSubjectAssignmentId = teacherSubjectAssignmentId;
		this.teacher = teacher;
		this.subject = subject;
		this.year = year;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
