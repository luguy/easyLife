package com.easylife.item.service;


import com.easylife.item.pojo.Category;

import java.util.List;

/**
 * @author luguy
 * @date 2019/10/6 - 22:18
 * @Description:
 * @Version:
 */
public interface CategoryService {

    /**
     * 根据id查询分类
     * @param pid
     * @return
     */
    List<Category> queryLast();

    /**
     * 查询当前数据库中最后一条数据
     * @return
     */
    List<Category> queryCategoryByPid(Long pid);

}
