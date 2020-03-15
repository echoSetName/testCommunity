package com.example.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showFirstPage;
    private boolean showPrevisous;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        // 判断最大页码
        totalPage = 0;
        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }
        else{
            totalPage = (totalCount / size) + 1;
        }

        // 判断输入的页面是否超过范围
        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }

        // 将计算出来的page赋值给pagination的page
        this.page = page;

        pages = new ArrayList<Integer>();
        pages.add(page);
        for(int i=1; i<=3; i++){
            if(page - i > 0){
                pages.add(0,page - i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }

        // 上一页
        if(page == 1){
            showPrevisous = false;
        }
        else{
            showPrevisous = true;
        }


        // 下一页
        if(page == totalPage){
            showNext = false;
        }
        else{
            showNext = true;
        }


        // 第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }
        else {
            showFirstPage = true;
        }

        // 最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }
        else{
            showEndPage = true;
        }
    }
}
