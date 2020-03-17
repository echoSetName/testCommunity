package com.example.community.service;

import com.example.community.dto.PaginationDTO;
import com.example.community.dto.QuestionDTO;

public interface QuestionDTOService {
    PaginationDTO list(Integer page, Integer size);
    PaginationDTO list(Integer userId, Integer page, Integer size);

    QuestionDTO getById(Integer id);
}
