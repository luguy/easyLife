package com.easylife.item.controller;

import com.easylife.item.pojo.Category;
import com.easylife.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luguy
 * @date 2019/10/6 - 22:10
 * @Description:
 * @Version:
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点查询商品类目
     * @param pid
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam("pid") Long pid){

        //如果pid的值为-1那么需要获取数据库中最后一条数据
        if (pid == -1){
            List<Category> last = this.categoryService.queryLast();
            return ResponseEntity.ok(last);
        }
        else {
            List<Category> list = this.categoryService.queryCategoryByPid(pid);
            if (list == null) {
                //没有找到返回404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //找到返回200
            return ResponseEntity.ok(list);
        }
    }
}
