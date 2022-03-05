package com.mqxu.web.brand.mapper;

import com.mqxu.web.brand.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: BrandMapper接口
 * @author: mqxu
 * @date: 2022-03-04
 **/
public interface BrandMapper {
    /**
     * 查询所有
     *
     * @return 数据集合
     */
    @Select("SELECT * FROM tb_brand ")
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand 待添加对象
     */
    @Insert("INSERT INTO tb_brand VALUES (NULL,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);


    /**
     * 批量删除
     *
     * @param ids 删除记录的id数组
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     *
     * @param begin 起始记录
     * @param size  每页数量
     * @return 当前页数据集合
     */
    @Select("SELECT * FROM tb_brand LIMIT #{begin} , #{size} ")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     *
     * @return int
     */
    @Select("SELECT COUNT(*) FROM tb_brand ")
    int selectTotalCount();


    /**
     * 分页条件查询
     *
     * @param begin 起始记录索引
     * @param size  每页数量
     * @param brand 查询条件对象
     * @return List<Brand> 当前页数据集合
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     *
     * @param brand 查询条件对象
     * @return int
     */
    int selectTotalCountByCondition(Brand brand);
}
