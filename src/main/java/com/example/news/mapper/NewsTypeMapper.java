package com.example.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.news.pojo.NewsType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsTypeMapper extends BaseMapper<NewsType> {
}
