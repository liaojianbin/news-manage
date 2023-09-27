package com.example.news.controller;

import com.example.news.pojo.NewsType;
import com.example.news.pojo.Result;
import com.example.news.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/newsType")
@RequiredArgsConstructor
public class NewsTypeController {

    private final NewsTypeService newsTypeService;

    /**
     * 根据主键查询
     * @param id 主键
     * @return 实体
     */
    @GetMapping("/{id}")
    public NewsType findOne(@PathVariable Long id){
        return newsTypeService.getById(id);
    }

    /**
     * 根据主键查询
     * @param parentId 父id
     * @return 实体
     */
    @GetMapping("/p/{parentId}")
    public List<NewsType> findByParentId(@PathVariable Long parentId){
        return newsTypeService.findByParentId(parentId);
    }
    /**
     * 查询所有
     * @return 实体列表
     */
    @GetMapping("/all")
    public List<NewsType> findAll(){
        return newsTypeService.list();
    }

}
