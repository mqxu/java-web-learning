package com.mqxu.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 品牌实体类
 * @author: mqxu
 * @date: 2022-02-28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    /**
     * id 主键
     */
    private Integer id;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 排序字段
     */
    private Integer ordered;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 状态：0：禁用  1：启用
     */
    private Integer status;
}
