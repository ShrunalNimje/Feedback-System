package com.mymood.feedbacksystem.Feedback.System.DTO.Response;

import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;

public class TeacherSubjectResponseDTO {

    private Long teacherId;
    private Long subjectId;
    private String teacherName;
    private String subjectCode;
    private String subjectName;
    private SubjectType subjectType;
    private Integer semester;
    private String batchName;
    private String sectionName;
    private String branchName;
    private String departmentName;
    private String enrollmentId;
    private String studentName;

    public TeacherSubjectResponseDTO() {
    }

    public TeacherSubjectResponseDTO(Long teacherId, Long subjectId, String teacherName, String subjectCode,
                                     String subjectName, SubjectType subjectType, Integer semester, String batchName,
                                     String sectionName, String branchName, String departmentName, String enrollmentId,
                                     String studentName) {
        super();
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.teacherName = teacherName;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.semester = semester;
        this.batchName = batchName;
        this.sectionName = sectionName;
        this.branchName = branchName;
        this.departmentName = departmentName;
        this.enrollmentId = enrollmentId;
        this.studentName = studentName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public Integer getSemester() {
        return semester;
    }

    public String getBatchName() {
        return batchName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public String getStudentName() {
        return studentName;
    }
}
