package com.example.community.cache;

import com.example.community.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class HotTagCache {

    private List<String> hots = new ArrayList<>();

    public void updateTags(Map<String, Integer> tags){
        int max = 10;
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>();

        tags.forEach((name, priority)->{
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size() < max){
                priorityQueue.add(hotTagDTO);
            }else{
                HotTagDTO minHOt = priorityQueue.peek();
                if (hotTagDTO.compareTo(minHOt) > 0){
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });

        List<String> sortedTags = new ArrayList<>();

        HotTagDTO poll = priorityQueue.poll();
        while(poll != null){
            sortedTags.add(0, poll.getName());
            poll = priorityQueue.poll();
        }
        hots = sortedTags;
    }
}
