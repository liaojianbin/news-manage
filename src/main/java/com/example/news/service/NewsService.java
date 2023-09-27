package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.news.pojo.Result;
import com.example.news.pojo.News;

public interface NewsService extends IService<News> {
    Result search(Integer pageNum, Integer pageSize, News news);
}
