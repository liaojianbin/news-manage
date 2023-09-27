package com.example.news.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.news.pojo.Result;
import com.example.news.service.NewsService;
import com.example.news.mapper.NewsMapper;
import com.example.news.pojo.News;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public Result search(Integer pageNum, Integer pageSize, News news) {
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper<>();
        if (news != null) {
            if (StringUtils.isNotBlank(news.getNewsName())) {
                queryWrapper.like(News::getNewsName, news.getNewsName());
            }
        }

        Page<News> page = newsMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        return Result.data(page);
    }
}
