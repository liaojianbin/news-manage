package com.example.news.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.news.mapper.NewsTypeMapper;
import com.example.news.pojo.NewsType;
import com.example.news.pojo.Result;
import com.example.news.service.NewsTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsTypeImpl extends ServiceImpl<NewsTypeMapper, NewsType> implements NewsTypeService {
    @Resource
    private NewsTypeMapper newsTypeMapper;


    @Override
    public List<NewsType> findByParentId(Long parentId) {
        LambdaQueryWrapper<NewsType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(NewsType::getParentId, parentId);
        return newsTypeMapper.selectList(queryWrapper);
    }
}
