package com.example.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.news.pojo.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
}
