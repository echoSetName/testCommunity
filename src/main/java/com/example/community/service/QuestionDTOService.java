package com.example.community.service;

import com.example.community.dto.PaginationDTO;

public interface QuestionDTOService {
    PaginationDTO list(Integer page, Integer size);
}
