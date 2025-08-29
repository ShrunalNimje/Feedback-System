package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SectionRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SectionResponseDTO;

public interface SectionService {

	SectionResponseDTO createSection(SectionRequestDTO create);
	void deleteSection(Long id);
	SectionResponseDTO updateSection(Long id, SectionRequestDTO update);
	List<SectionResponseDTO> getAllSection();
	SectionResponseDTO getSection(Long id);
}
