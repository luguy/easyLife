package com.easylife.item.mapper;

import com.easylife.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

/**
 * @author luguy
 * @date 2019/10/6 - 22:17
 * @Description:
 * @Version:
 */
public interface CategoryMapper extends Mapper<Category> {

    /**
     * 查询最后一条数据
     * @return
     */
    @Select("SELECT * FROM `tb_category` WHERE id = (SELECT MAX(id) FROM tb_category)")
    List<Category> selectLast();

}
