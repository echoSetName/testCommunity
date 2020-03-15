package com.example.community.dataobject;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Question {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    public Question() {
    }

    public Question(String title, String description, Long gmtCreate, Long gmtModified, Integer creator, Integer commentCount, Integer viewCount, Integer likeCount, String tag) {
        this.title = title;
        this.description = description;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.creator = creator;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.tag = tag;
    }
}
