package com.easylife.item.service;


import com.easylife.common.pojo.BrandQueryByPageParameter;
import com.easylife.common.pojo.PageResult;
import com.easylife.item.pojo.Brand;

import java.util.List;


/**
 * @Author: 98050
 * Time: 2018-08-07 19:16
 * Feature: 分类的业务层
 */

public interface BrandService {

    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter);

    /**
     * 新增brand,并且维护中间表
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> categories);
}
