package com.mymood.feedbacksystem.Feedback.System.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mymood.feedbacksystem.Feedback.System.Entity.*;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;
import com.mymood.feedbacksystem.Feedback.System.Repository.*;


@Component
public class CustomCommandLineRunner implements CommandLineRunner{

	@Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private BranchRepository branchRepository;
    
    @Autowired
    private SectionRepository sectionRepository;
    
    @Autowired
    private BatchRepository batchRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private TeacherSubjectAssignmentRepository assignmentRepository;
    
    @Autowired
    private UserRepository userRepository;
    
	@Override
	public void run(String... args) throws Exception {
		
        assignmentRepository.deleteAll();
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        subjectRepository.deleteAll();
        batchRepository.deleteAll();
        sectionRepository.deleteAll();
        branchRepository.deleteAll();
        departmentRepository.deleteAll();
        userRepository.deleteAll();
        
        DepartmentEntity dept = new DepartmentEntity();
        dept.setName("Computer Science");
        departmentRepository.save(dept);

        BranchEntity branch = new BranchEntity();
        branch.setName("CSE");
        branch.setDepartment(dept);
        branchRepository.save(branch);

        SectionEntity section = new SectionEntity();
        section.setName("A");
        section.setBranch(branch);
        sectionRepository.save(section);

        BatchEntity batch = new BatchEntity();
        batch.setName("A2");
        batch.setSection(section);
        batchRepository.save(batch);

        UserEntity user = new UserEntity();
        user.setUsername("John Doe");
        user.setPassword("password");
        user.setRole(Role.STUDENT);
        userRepository.save(user);
        
        StudentEntity student = new StudentEntity();
        student.setName("John Doe");
        student.setEmail("john@example.com");
        student.setEnrollmentId("ENR12345");
        student.setAttendancePercentage(85f);
        student.setBatch(batch);
        student.setBranch(branch);
        student.setDepartment(dept);
        student.setSection(section);
        student.setSemester(5);
        student.setYear(2023);
        student.setPassword("password123");
        student.setUser(user);
        student.setRollNo(54);
        studentRepository.save(student);


        TeacherEntity teacher = new TeacherEntity();
        teacher.setName("Dr. Smith");
        teacher.setEmail("smith@example.com");
        teacher.setDepartment(dept);
        teacher.setPassword("teacher123");
        teacherRepository.save(teacher);

        SubjectEntity subject = new SubjectEntity();
        subject.setName("Data Structures");
        subject.setCode("CS201");
        subject.setType(SubjectType.PRACTICAL);;
        subject.setDepartment(dept);
        subject.setSemester(1);
        subjectRepository.save(subject);

        TeacherSubjectAssignmentEntity assignment = new TeacherSubjectAssignmentEntity();
        assignment.setTeacher(teacher);
        assignment.setSubject(subject);
        assignment.setSection(section);
        assignment.setBatch(batch);
        assignment.setYear(2025);
        assignment.setSemester(1);
        assignmentRepository.save(assignment);
		
	}

}
