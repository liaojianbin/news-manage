package com.example.news.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_news")
public class News implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String newsName;
    private Long newsTypeId;
}
