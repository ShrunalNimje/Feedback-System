package com.mymood.feedbacksystem.Feedback.System.Service;

import java.util.List;

import com.mymood.feedbacksystem.Feedback.System.DTO.Request.SubjectRequestDTO;
import com.mymood.feedbacksystem.Feedback.System.DTO.Response.SubjectResponseDTO;

public interface SubjectService {

	SubjectResponseDTO createSubject(SubjectRequestDTO create);
    SubjectResponseDTO getSubject(Long id);
    List<SubjectResponseDTO> getAllSubject();
    SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO update);
    void deleteSubject(Long id);
}
