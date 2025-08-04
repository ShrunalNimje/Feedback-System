package com.mymood.feedbacksystem.Feedback.System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "students")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(unique = true, nullable = false)
	private String enrollmentId;
	
	@Column(unique = false, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	@Email(message = "Mail Id should be valid!")
	private String email;
	
	@Column(unique = false, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Integer semester;
	
	@Column(nullable = false)
	private Float attendance_percentage;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private DepartmentEntity department;
	
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private BranchEntity branch;
	
	@ManyToOne
	@JoinColumn(name = "section_id", nullable = false)
	private SectionEntity section;
	
	@ManyToOne
	@JoinColumn(name = "batch_id", nullable = false)
	private BatchEntity batch;
	
	public StudentEntity() {
		
	}

	public StudentEntity(Long studentId, String enrollmentId, String name, String email, String password, Integer year, Integer semester,
			Float attendance_percentage, DepartmentEntity department, BranchEntity branch, SectionEntity section,
			BatchEntity batch) {
		super();
		this.studentId = studentId;
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.year = year;
		this.semester = semester;
		this.attendance_percentage = attendance_percentage;
		this.department = department;
		this.branch = branch;
		this.section = section;
		this.batch = batch;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Float getAttendance_percentage() {
		return attendance_percentage;
	}

	public void setAttendance_percentage(Float attendance_percentage) {
		this.attendance_percentage = attendance_percentage;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
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
