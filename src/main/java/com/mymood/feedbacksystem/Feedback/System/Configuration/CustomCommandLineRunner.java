package com.mymood.feedbacksystem.Feedback.System.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mymood.feedbacksystem.Feedback.System.Entity.*;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Enum.SubjectType;
import com.mymood.feedbacksystem.Feedback.System.Repository.*;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    @Autowired private DepartmentRepository departmentRepository;
    @Autowired private BranchRepository branchRepository;
    @Autowired private SectionRepository sectionRepository;
    @Autowired private BatchRepository batchRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private TeacherRepository teacherRepository;
    @Autowired private SubjectRepository subjectRepository;
    @Autowired private TeacherSubjectAssignmentRepository assignmentRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private FeedbackRepository feedbackRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

    	feedbackRepository.deleteAll();
        assignmentRepository.deleteAll();
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        subjectRepository.deleteAll();
        batchRepository.deleteAll();
        sectionRepository.deleteAll();
        branchRepository.deleteAll();
        departmentRepository.deleteAll();
        userRepository.deleteAll();

        Random random = new Random();
        
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

        // Admin User
        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        // Teachers
        List<TeacherEntity> teachers = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            UserEntity teacherUser = new UserEntity();
            teacherUser.setUsername("teacher" + i + "@example.com");
            teacherUser.setPassword(passwordEncoder.encode("teacher123"));
            teacherUser.setRole(Role.TEACHER);
            userRepository.save(teacherUser);

            TeacherEntity teacher = new TeacherEntity();
            teacher.setName("Teacher " + i);
            teacher.setEmail("teacher" + i + "@example.com");
            teacher.setDepartment(dept);
            teacher.setUser(teacherUser);
            teacherRepository.save(teacher);
            teachers.add(teacher);
        }

        // Subjects
        List<SubjectEntity> subjects = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            SubjectEntity subject = new SubjectEntity();
            subject.setName("Subject " + i);
            subject.setCode("CS20" + i);
            subject.setType(i % 2 == 0 ? SubjectType.THEORY : SubjectType.PRACTICAL);
            subject.setDepartment(dept);
            subject.setSemester(random.nextInt(1, 2));
            subjectRepository.save(subject);
            subjects.add(subject);
        }

        // Teacher-Subject Assignments (round-robin)
        int subjIndex = 0;
        for (TeacherEntity teacher : teachers) {
            SubjectEntity subject = subjects.get(subjIndex % subjects.size());
            TeacherSubjectAssignmentEntity assignment = new TeacherSubjectAssignmentEntity();
            assignment.setTeacher(teacher);
            assignment.setSubject(subject);
            assignment.setBatch(batch);
            assignment.setSection(section);
            assignment.setSemester(random.nextInt(1, 2));
            assignmentRepository.save(assignment);
            subjIndex++;
        }

        // Students
        List<StudentEntity> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            UserEntity studentUser = new UserEntity();
            studentUser.setUsername("2022AAIE11010" + i);
            studentUser.setPassword(passwordEncoder.encode("student123"));
            studentUser.setRole(Role.STUDENT);
            userRepository.save(studentUser);

            StudentEntity student = new StudentEntity();
            student.setName("Student " + i);
            student.setEmail("student" + i + "@raisoni.net");
            student.setEnrollmentId("2022AAIE11010" + i);
            student.setAttendancePercentage(80.f + i);
            student.setBatch(batch); 
            student.setBranch(branch); 
            student.setSection(section); 
            student.setDepartment(dept);
            student.setSemester(random.nextInt(1, 2)); 
            student.setRollNo(i); 
            student.setUser(studentUser);
            studentRepository.save(student);
            students.add(student);
        }

        double defaultLat = 19.9975;
        double defaultLong = 73.789;

        for (StudentEntity student : students) {
            for (TeacherSubjectAssignmentEntity assignment : assignmentRepository.findAll()) {
                
            	FeedbackEntity feedback = new FeedbackEntity();
                feedback.setStudent(student);
                feedback.setTeacher(assignment.getTeacher());
                feedback.setSubject(assignment.getSubject());
                feedback.setSemester(assignment.getSemester());
                feedback.setLatitude(defaultLat);
                feedback.setLongitude(defaultLong);

                feedback.setQuestion1_rating(random.nextInt(5) + 1);
                feedback.setQuestion2_rating(random.nextInt(5) + 1);
                feedback.setQuestion3_rating(random.nextInt(5) + 1);
                feedback.setQuestion4_rating(random.nextInt(5) + 1);
                feedback.setQuestion5_rating(random.nextInt(5) + 1);

                feedbackRepository.save(feedback);
        	}
        }
    }
}