package com.easylife.item.service.impl;


import com.easylife.item.mapper.CategoryMapper;
import com.easylife.item.pojo.Category;
import com.easylife.item.service.CategoryService;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luguy
 * Time: 2018-08-07 19:16
 * Feature: 分类的业务层
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点id查询分类
     * @param pid
     * @return
     */
    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }

    /**
     * 查询数据库中最后一条数据
     * @return
     */
    @Override
    public List<Category> queryLast() {
        List<Category> last =this.categoryMapper.selectLast();
        return last;
    }

}
