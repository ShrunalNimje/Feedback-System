package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SectionRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SectionResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Update.SectionUpdateDTO;
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
		
		if (sectionRepository.existsByName(create.getName())) {
		    throw new RuntimeException("Section already exists");
		}

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
	public SectionResponseDTO updateSection(Long id, SectionUpdateDTO update) {
		
		SectionEntity sec = sectionRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Section not found!"));
		
		if (update.getName() != null) {
		    if (sectionRepository.existsByName(update.getName())
		            && !sec.getName().equals(update.getName())) {
		        throw new RuntimeException("Another section with this name already exists");
		    }
		    sec.setName(update.getName());
		}
		
		if(update.getBranchId() != null) {
			BranchEntity branch = branchRepository.findById(update.getBranchId())
					.orElseThrow(() -> new RuntimeException("Branch not found!"));
			
			sec.setBranch(branch);
		}
		
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
