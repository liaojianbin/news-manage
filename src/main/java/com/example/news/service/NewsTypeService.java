package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.news.pojo.NewsType;
import com.example.news.pojo.Result;

import java.util.List;

public interface NewsTypeService extends IService<NewsType> {

    List<NewsType> findByParentId(Long parentId);
}
