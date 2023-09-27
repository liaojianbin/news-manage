package com.example.news.controller;

import com.example.news.pojo.News;
import com.example.news.pojo.Result;
import com.example.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    /**
     * 新增
     * @param news 实体
     * @return 操作结果
     */
    @PostMapping
    public Result add(@RequestBody News news){
        try {
            newsService.save(news);
            return Result.ok("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("新增失败");
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 实体
     */
    @GetMapping("/{id}")
    public News findOne(@PathVariable Long id){
        return newsService.getById(id);
    }

    /**
     * 修改
     * @param news 实体
     * @return 操作结果
     */
    @PutMapping
    public Result update(@RequestBody News news){
        try {
            newsService.updateById(news);
            return Result.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("修改失败");
    }

    /**
     * 根据主键数组批量删除
     * @param ids 主键数组
     * @return 实体
     */
    @DeleteMapping
    public Result delete(Long[] ids){
        try {
            newsService.removeByIds(Arrays.asList(ids));
            return Result.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("删除失败");
    }

    /**
     * 根据条件搜索
     * @param pageNum 页号
     * @param pageSize 页面大小
     * @param news 搜索条件
     * @return 分页信息
     */
    @PostMapping("/search")
    public Result search(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize,
                                  @RequestBody News news) {
        return newsService.search(pageNum, pageSize, news);
    }


}
