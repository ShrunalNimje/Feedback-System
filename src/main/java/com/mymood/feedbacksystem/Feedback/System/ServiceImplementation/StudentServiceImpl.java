package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentCSVDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Request.StudentRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.StudentResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.TeacherSubjectResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.StudentUpdateDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.BranchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.DepartmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.StudentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.TeacherSubjectAssignmentEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.UserEntity;
import com.mymood.feedbacksystem.Feedback.System.Enum.Role;
import com.mymood.feedbacksystem.Feedback.System.Repository.BatchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.BranchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.DepartmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SectionRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.StudentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.TeacherSubjectAssignmentRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.UserRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.StudentService;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	TeacherSubjectAssignmentRepository assignmentRepository;
	
	@Override
	public StudentResponseDTO createStudent(StudentRequestDTO create) {
		
		if (userRepository.existsByUsername(create.getEnrollmentId())) {
	        throw new RuntimeException("Enrollment ID already exists as username!");
	    }
		
		BatchEntity batch = batchRepository.findById(create.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found!"));

		UserEntity user = new UserEntity();
		user.setPassword(passwordEncoder.encode(create.getPassword()));
		user.setUsername(create.getEnrollmentId());
		user.setRole(Role.STUDENT);
		userRepository.save(user);
		
        StudentEntity student = new StudentEntity();
        student.setName(create.getName());
        student.setRollNo(create.getRollNo()); 
        student.setEmail(create.getEmail());
        student.setBatch(batch);
        student.setEnrollmentId(create.getEnrollmentId());
        student.setUser(user);
        student.setAttendancePercentage(create.getAttendance());
        student.setSection(batch.getSection());
        student.setBranch(batch.getSection().getBranch());
        student.setDepartment(batch.getSection().getBranch().getDepartment());
        student.setSemester(create.getSemester());
        
        StudentEntity saved = studentRepository.save(student);
        
        return new StudentResponseDTO(
        		saved.getStudentId(),
        		saved.getName(),
        		saved.getRollNo(),
        		saved.getEmail(),
        		saved.getBatch().getName(),
        		saved.getEnrollmentId()
        );
	}

	@Override
	public StudentResponseDTO getStudent(Long id) {
		
		StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        
		return new StudentResponseDTO(
				student.getStudentId(),
				student.getName(),
				student.getRollNo(),
				student.getEmail(),
        		student.getBatch().getName(),
        		student.getEnrollmentId()
        );
	}

	@Override
	public List<StudentResponseDTO> getAllStudent() {

		return studentRepository.findAll().stream()
                .map(student -> new StudentResponseDTO(
        				student.getStudentId(),
        				student.getName(),
        				student.getRollNo(),
        				student.getEmail(),
                		student.getBatch().getName(),
                		student.getEnrollmentId()
                ))
                .collect(Collectors.toList());
	}

	@Override
	public StudentResponseDTO updateStudent(Long id, StudentUpdateDTO update) {
		
		StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
		
		if(update.getName() != null) {
			student.setName(update.getName());
		}
		
		if(update.getRollNo() != null) {
			student.setRollNo(update.getRollNo());
		}
		
		if(update.getEmail() != null) {
	        student.setEmail(update.getEmail());
		}
		
		if(update.getBatchId() != null) {
			BatchEntity batch = batchRepository.findById(update.getBatchId())
	                .orElseThrow(() -> new RuntimeException("Batch not found!"));
			
	        student.setBatch(batch);
		}

        StudentEntity saved = studentRepository.save(student);

        return new StudentResponseDTO(
        		saved.getStudentId(),
        		saved.getName(),
        		saved.getRollNo(),
        		saved.getEmail(),
        		saved.getBatch().getName(),
        		saved.getEnrollmentId()
        );
	}

	@Override
	public void deleteStudent(Long id) {
		
		studentRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Student not found!"));
		
		studentRepository.deleteById(id);
	}
	
	@Override
	public List<TeacherSubjectResponseDTO> getAutoMappedFeedbackForm(String enrollmentId) {
	    
		StudentEntity student = studentRepository.findByEnrollmentId(enrollmentId)
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    List<TeacherSubjectAssignmentEntity> assignments =assignmentRepository.findBySectionAndBatch(
	            student.getSection(), student.getBatch());

	    return assignments.stream().map(
	    		a -> new TeacherSubjectResponseDTO(
	    				a.getTeacher().getTeacherId(),
	    				a.getSubject().getSubjectId(),
	    				a.getTeacher().getName(),
				        a.getSubject().getCode(),
				        a.getSubject().getName(),
				        a.getSubject().getType(),
				        a.getSemester(),
				        a.getBatch().getName(),
				        a.getSection().getName(),
				        a.getSection().getBranch().getName(),
				        a.getSection().getBranch().getDepartment().getName(),
				        student.getEnrollmentId(),
	                    student.getName()   
				        )).
	    		collect(Collectors.toList());
	}
	
//	@Override
//	public List<StudentCSVDTO> parseCSV(MultipartFile file) throws Exception {
//	    try (Reader reader = new InputStreamReader(file.getInputStream())) {
//
//	        CsvToBean<StudentCSVDTO> csvToBean = new CsvToBeanBuilder<StudentCSVDTO>(reader)
//	                .withType(StudentCSVDTO.class)
//	                .withIgnoreLeadingWhiteSpace(true)
//	                .withSkipLines(1)
//	                .build();
//
//	        List<StudentCSVDTO> students = csvToBean.parse();
//	        return students;
//	    }
//	}
	
//	@Override
//	public void saveStudentsFromCSV(MultipartFile file) throws Exception {
//	    
//		try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new InputStreamReader(file.getInputStream()))) {
//	        
//			Map<String, String> row;
//	        int rowNumber = 1;
//	       
//	        while ((row = reader.readMap()) != null) {
//	            rowNumber++;
//
//	            String enrollmentId = getValueIgnoreCase(row, "enrollmentId");
//	            String name = getValueIgnoreCase(row, "name");
//	            
//	            String rollNoStr = getValueIgnoreCase(row, "rollNo");
//	            Integer rollNo = rollNoStr != null ? Integer.parseInt(rollNoStr) : null;
//	            
//	            String email = getValueIgnoreCase(row, "email");
//	            
//	            String semesterStr = getValueIgnoreCase(row, "semester");
//	            Integer semester = (semesterStr != null && !semesterStr.isBlank()) ? Integer.parseInt(semesterStr) : 1;	            String password = getValueIgnoreCase(row, "password");
//	            
//	            String departmentName = getValueIgnoreCase(row, "department");
//	            String branchName = getValueIgnoreCase(row, "branch");
//	            String sectionName = getValueIgnoreCase(row, "section");
//	            String batchName = getValueIgnoreCase(row, "batch");
//	            
//	            String attendanceStr = getValueIgnoreCase(row, "attendancePercentage");
//	            Float attendancePercentage = (attendanceStr != null && !attendanceStr.isBlank()) ? Float.parseFloat(attendanceStr) : 0f;
//	         
//	            if (name == null || rollNo == null || email == null || departmentName == null || branchName == null || 
//	            		sectionName == null || semester == null || attendancePercentage == null || 
//	            		batchName == null || enrollmentId == null) {
//	                throw new IllegalArgumentException("Missing required value in CSV row " + rowNumber);
//	            }
//
//	            DepartmentEntity dept = findOrCreateDepartment(departmentName);
//	            BranchEntity branch = findOrCreateBranch(branchName, dept);
//	            SectionEntity section = findOrCreateSection(sectionName);
//	            BatchEntity batch = findOrCreateBatch(batchName, section);
//	            UserEntity user = createUserEntity(enrollmentId, password);
//
//	            StudentCSVDTO dto = new StudentCSVDTO(
//	            	    enrollmentId, name, rollNo, departmentName, branchName,
//	            	    sectionName, batchName, email, semester, password, attendancePercentage
//	            	);
//
//	            StudentEntity student = mapDTOToStudent(dto, dept, branch, section, batch, user);
//	            studentRepository.save(student);
//
//
//	            studentRepository.save(student);
//	        }
//	    }
//	}

//	@Override
//	public void saveStudentsFromCSV(MultipartFile file) throws Exception {
//
//	    // Clear caches for each import
//	    departmentCache.clear();
//	    branchCache.clear();
//	    sectionCache.clear();
//	    batchCache.clear();
//
//	    try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new InputStreamReader(file.getInputStream()))) {
//
//	        Map<String, String> row;
//	        int rowNumber = 1;
//
//	        while ((row = reader.readMap()) != null) {
//	            rowNumber++;
//
//	            String enrollmentId = getValueIgnoreCase(row, "enrollmentId");
//	            String name = getValueIgnoreCase(row, "name");
//	            String rollNoStr = getValueIgnoreCase(row, "rollNo");
//	            Integer rollNo = rollNoStr != null ? Integer.parseInt(rollNoStr) : null;
//	            String email = getValueIgnoreCase(row, "email");
//	            Integer semester = Integer.parseInt(getValueIgnoreCase(row, "semester"));
//	            String password = getValueIgnoreCase(row, "password");
//	            String departmentName = getValueIgnoreCase(row, "department");
//	            String branchName = getValueIgnoreCase(row, "branch");
//	            String sectionName = getValueIgnoreCase(row, "section");
//	            String batchName = getValueIgnoreCase(row, "batch");
//	            String attendanceStr = getValueIgnoreCase(row, "attendancePercentage");
//	            Float attendancePercentage = attendanceStr != null ? Float.parseFloat(attendanceStr) : 0f;
//
//	            // Check required fields
//	            if (name == null || rollNo == null || email == null || departmentName == null || branchName == null ||
//	                    sectionName == null || semester == null || batchName == null || enrollmentId == null) {
//	                throw new IllegalArgumentException("Missing required value in CSV row " + rowNumber);
//	            }
//
//	            // Ensure password
//	            if (password == null || password.isBlank()) {
//	                password = generateRandomPassword(6);
//	            }
//
//	            // Find or create entities using cached methods
//	            DepartmentEntity dept = findOrCreateDepartment(departmentName);
//	            BranchEntity branch = findOrCreateBranch(branchName, dept);
//	            SectionEntity section = findOrCreateSection(sectionName);
//	            BatchEntity batch = findOrCreateBatch(batchName, section);
//
//	            // Create user entity
//	            UserEntity user = createUserEntity(enrollmentId, password);
//
//	            // Map DTO and save student
//	            StudentCSVDTO dto = new StudentCSVDTO(
//	                    enrollmentId, name, rollNo, departmentName, branchName,
//	                    sectionName, batchName, email, semester, password, attendancePercentage
//	            );
//
//	            StudentEntity student = mapDTOToStudent(dto, dept, branch, section, batch, user);
//	            studentRepository.save(student);
//	        }
//	    }
//	}
//
//	private String getValueIgnoreCase(Map<String, String> row, String key) {
//	    for (Map.Entry<String, String> entry : row.entrySet()) {
//	        if (entry.getKey().trim().equalsIgnoreCase(key)) {
//	        	String value = entry.getValue();
//	            return (value != null) ? value.trim() : null;	        }
//	    }
//	    return null;
//	}
//
//	private final Map<String, DepartmentEntity> departmentCache = new HashMap<>();
//	private final Map<String, BranchEntity> branchCache = new HashMap<>();
//	private final Map<String, SectionEntity> sectionCache = new HashMap<>();
//	private final Map<String, BatchEntity> batchCache = new HashMap<>();
//
//	private DepartmentEntity findOrCreateDepartment(String name) {
//	    String key = name.trim().toLowerCase();
//	    return departmentCache.computeIfAbsent(key, k ->
//	        departmentRepository.findByName(name.trim())
//	            .orElseGet(() -> departmentRepository.save(new DepartmentEntity(name.trim())))
//	    );
//	}
//
//	private BranchEntity findOrCreateBranch(String name, DepartmentEntity department) {
//	    String key = department.getDepartmentId() + "_" + name.trim().toLowerCase();
//	    return branchCache.computeIfAbsent(key, k ->
//	        branchRepository.findByNameAndDepartmentId(name.trim(), department.getDepartmentId())
//	            .orElseGet(() -> {
//	                BranchEntity branch = new BranchEntity();
//	                branch.setName(name.trim());
//	                branch.setDepartment(department);
//	                return branchRepository.save(branch);
//	            })
//	    );
//	}
//
//	private SectionEntity findOrCreateSection(String name) {
//	    String key = name.trim().toLowerCase();
//	    return sectionCache.computeIfAbsent(key, k ->
//	        sectionRepository.findByName(name.trim())
//	            .orElseGet(() -> sectionRepository.save(new SectionEntity(name.trim())))
//	    );
//	}
//
//	private BatchEntity findOrCreateBatch(String name, SectionEntity section) {
//	    String key = section.getSectionId() + "_" + name.trim().toLowerCase();
//	    return batchCache.computeIfAbsent(key, k ->
//	        batchRepository.findByNameAndSectionId(name.trim(), section.getSectionId())
//	            .orElseGet(() -> {
//	                BatchEntity batch = new BatchEntity();
//	                batch.setName(name.trim());
//	                batch.setSection(section);
//	                return batchRepository.save(batch);
//	            })
//	    );
//	}
//	private DepartmentEntity findOrCreateDepartment(String name) {
//	    return departmentRepository.findByName(name)
//	            .orElseGet(() -> departmentRepository.save(new DepartmentEntity(name)));
//	}
//	
//	private BranchEntity findOrCreateBranch(String name, DepartmentEntity department) {
//	    return branchRepository.findByNameAndDepartment(name, department)
//	            .orElseGet(() -> {
//	                BranchEntity branch = new BranchEntity();
//	                branch.setName(name);
//	                branch.setDepartment(department);
//	                return branchRepository.save(branch);
//	            });
//	}
//
//	private SectionEntity findOrCreateSection(String name) {
//	    return sectionRepository.findByName(name)
//	            .orElseGet(() -> sectionRepository.save(new SectionEntity(name)));
//	}
//
//	private BatchEntity findOrCreateBatch(String name, SectionEntity section) {
//	    return batchRepository.findByNameAndSection(name, section)
//	            .orElseGet(() -> {
//	                BatchEntity batch = new BatchEntity();
//	                batch.setName(name);
//	                batch.setSection(section);
//	                return batchRepository.save(batch);
//	            });
//	}
//
//	private UserEntity createUserEntity(String enrollmentId, String password) {
//	    UserEntity user = new UserEntity();
//	    user.setUsername(enrollmentId);
//
//	    if (password == null || password.isBlank()) {
//	        password = generateRandomPassword(6);
//	    }
//
//	    user.setPassword(passwordEncoder.encode(password));
//	    user.setRole(Role.STUDENT);
//	    return userRepository.save(user);
//	}
//
//	private StudentEntity mapDTOToStudent(StudentCSVDTO dto, DepartmentEntity department,
//            BranchEntity branch, SectionEntity section, BatchEntity batch, UserEntity user) {
//		
//		StudentEntity student = new StudentEntity();
//		
//		student.setEnrollmentId(dto.getEnrollmentId());
//		student.setName(dto.getName());
//		student.setRollNo(dto.getRollNo());
//		student.setEmail(dto.getEmail());
//		student.setSemester(dto.getSemester());
//		student.setDepartment(department);
//		student.setBranch(branch);
//		student.setSection(section);
//		student.setBatch(batch);
//		student.setUser(user);
//		student.setAttendancePercentage(dto.getAttendancePercentage());
//		
//		return student;
//	}
//
//	private String generateRandomPassword(int length) {
//	    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//	    StringBuilder sb = new StringBuilder();
//	    Random random = new Random();
//	    for (int i = 0; i < length; i++) {
//	        sb.append(chars.charAt(random.nextInt(chars.length())));
//	    }
//	    return sb.toString();
//	}

}
