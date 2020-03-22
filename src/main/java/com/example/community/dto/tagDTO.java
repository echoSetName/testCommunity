package com.example.community.dto;

import lombok.Data;

import java.util.List;

@Data
public class tagDTO {
    private String categoryName;
    private List<String> tags;
}
