package com.easylife.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luguy
 * @date 2019/10/6 - 22:02
 * @Description:
 * @Version:
 */
@Data
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;

}
