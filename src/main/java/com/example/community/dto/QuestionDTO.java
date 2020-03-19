package com.example.community.dto;

import com.example.community.model.UserInfo;
import lombok.Data;

@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private UserInfo user;

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
