package com.example.community.schedule;

import com.example.community.cache.HotTagCache;
import com.example.community.mapper.QuestionMapper;
import com.example.community.model.Question;
import com.example.community.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 1000 * 60 * 60 * 6)
    //@Scheduled(cron = "0 0 1 * * *")
    public void hatTagSchedule() {
        int offse = 0;
        int limit = 5;
        List<Question> list = new ArrayList<>();
        Map<String, Integer> priorities = new HashMap<>();
        while(offse == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offse, limit));
            for(Question question:list){

                String[] tags = StringUtils.split(question.getTag(),",");
                for (String tag : tags) {
                    Integer priority = priorities.get(tag);
                    if (priority != null){
                        priorities.put(tag, priority + 5 + question.getCommentCount());
                    }
                    else{
                        priorities.put(tag, 5 + question.getCommentCount());
                    }
                }

            }
            offse += limit;
        }
        hotTagCache.updateTags(priorities);
    }
}
