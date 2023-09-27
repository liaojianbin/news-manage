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
     * 新增
     * @param newsType 实体
     * @return 操作结果
     */
    @PostMapping
    public Result add(@RequestBody NewsType newsType){
        try {
            newsTypeService.save(newsType);
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

    /**
     * 修改
     * @param newsType 实体
     * @return 操作结果
     */
    @PutMapping
    public Result update(@RequestBody NewsType newsType){
        try {
            newsTypeService.updateById(newsType);
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
            newsTypeService.removeByIds(Arrays.asList(ids));
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
     * @param newsType 搜索条件
     * @return 分页信息
     */
    @PostMapping("/search")
    public Result search(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestBody NewsType newsType) {
        return newsTypeService.search(pageNum, pageSize, newsType);
    }


}
