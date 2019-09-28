package com.easylife.item.service.impl;


import com.easylife.common.pojo.BrandQueryByPageParameter;
import com.easylife.common.pojo.PageResult;
import com.easylife.item.mapper.BrandMapper;
import com.easylife.item.pojo.Brand;
import com.easylife.item.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: luguy
 * Time: 2018-08-07 19:16
 * Feature: 分类的业务层
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    @Override
    public PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter) {

        /**
         * 1.分页
         */
        PageHelper.startPage(brandQueryByPageParameter.getPage(),brandQueryByPageParameter.getRows());

        /**
         *  2.排序
         */
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(brandQueryByPageParameter.getSortBy())){
            example.setOrderByClause(brandQueryByPageParameter.getSortBy()+(brandQueryByPageParameter.getDesc()? " DESC":" ASC"));
        }
        /**
         * 3.查询
         */
        if(StringUtils.isNotBlank(brandQueryByPageParameter.getKey())) {
            example.createCriteria().orLike("name", brandQueryByPageParameter.getKey()+"%").orEqualTo("letter", brandQueryByPageParameter.getKey().toUpperCase());
        }
        List<Brand> list=this.brandMapper.selectByExample(example);

        /**
         * 4.创建PageInfo
         */
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        /**
         * 5.返回分页结果
         */
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 品牌新增
     * @param brand
     * @param categories
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBrand(Brand brand, List<Long> categories) {
        // 新增品牌信息
        this.brandMapper.insertSelective(brand);
        // 新增品牌和分类中间表
        for (Long cid : categories) {
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        }
    }
}
