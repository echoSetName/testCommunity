package com.example.community.dto;

import com.example.community.model.UserInfo;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer likeCount;

    private Integer commentCount;

    private String content;

    private UserInfo user;
}
