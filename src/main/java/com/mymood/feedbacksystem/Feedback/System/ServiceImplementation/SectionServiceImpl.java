package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SectionRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SectionResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BranchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.BranchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SectionRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{

	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	SectionRepository sectionRepository;
	
	@Override
	public SectionResponseDTO createSection(SectionRequestDTO create) {
		
		BranchEntity branch = branchRepository.findById(create.getBranchId())
				.orElseThrow(() -> new RuntimeException("Branch not found!"));
		
		SectionEntity sec = new SectionEntity();
		sec.setBranch(branch);
		sec.setName(create.getName());
		
		SectionEntity saved = sectionRepository.save(sec);
		return new SectionResponseDTO(saved.getSectionId(), saved.getName(), saved.getBranch().getName());
	}

	@Override
	public void deleteSection(Long id) {
		sectionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Section not found!"));
		
		sectionRepository.deleteById(id);
	}

	@Override
	public SectionResponseDTO updateSection(Long id, SectionRequestDTO update) {
		
		BranchEntity branch = branchRepository.findById(update.getBranchId())
				.orElseThrow(() -> new RuntimeException("Branch not found!"));
		
		SectionEntity sec = sectionRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Section not found!"));
		
		sec.setBranch(branch);
		sec.setName(update.getName());
		
		SectionEntity saved = sectionRepository.save(sec);
		return new SectionResponseDTO(id, saved.getName(), saved.getBranch().getName());
	}

	@Override
	public List<SectionResponseDTO> getAllSection() {
		
		return sectionRepository.findAll()
				.stream()
				.map(sec -> new SectionResponseDTO(
						sec.getSectionId(), 
						sec.getName(), 
						sec.getBranch().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public SectionResponseDTO getSection(Long id) {
		SectionEntity section = sectionRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Section not found!"));
		
		return new SectionResponseDTO(section.getSectionId(), section.getName(), section.getBranch().getName());
	}

}
