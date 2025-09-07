package com.mymood.feedbacksystem.Feedback.System.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.BatchRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.BatchResponseDTO;
import com.mymood.feedbacksystem.Feedback.System.Entity.BatchEntity;
import com.mymood.feedbacksystem.Feedback.System.Entity.SectionEntity;
import com.mymood.feedbacksystem.Feedback.System.Repository.BatchRepository;
import com.mymood.feedbacksystem.Feedback.System.Repository.SectionRepository;
import com.mymood.feedbacksystem.Feedback.System.Service.BatchService;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	BatchRepository batchRepository;
	
	@Override
	public BatchResponseDTO createBatch(BatchRequestDTO create) {
		
		SectionEntity section = sectionRepository.findById(create.getSectionId())
				.orElseThrow(() -> new RuntimeException("Section not found!"));
		
		BatchEntity batch = new BatchEntity();
		batch.setName(create.getName());
		batch.setSection(section);
		
		BatchEntity saved = batchRepository.save(batch);
		return new BatchResponseDTO(saved.getBatchId(), saved.getName(), section.getName());
	}

	@Override
	public void deleteBatch(Long id) {
		batchRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Batch not found!"));
		
		batchRepository.deleteById(id);
	}

	@Override
	public BatchResponseDTO updateBatch(Long id, BatchRequestDTO update) {

		BatchEntity batch = batchRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Batch not found!"));
		
		if(update.getName() != null) {
			batch.setName(update.getName());
		}
		
		if(update.getSectionId() != null) {
			SectionEntity section = sectionRepository.findById(update.getSectionId())
					.orElseThrow(() -> new RuntimeException("Section not found!"));
			
			batch.setSection(section);
		}
		
		BatchEntity saved = batchRepository.save(batch);
		return new BatchResponseDTO(id, saved.getName(), saved.getSection().getName());
	}

	@Override
	public List<BatchResponseDTO> getAllBatch() {
		
		return batchRepository.findAll()
				.stream()
				.map(batch -> new BatchResponseDTO(
						batch.getBatchId(), 
						batch.getName(), 
						batch.getSection().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public BatchResponseDTO getBatch(Long id) {
		
		BatchEntity batch = batchRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Batch not found!"));
		
		return new BatchResponseDTO(id, batch.getName(), batch.getSection().getName());
	}

}
