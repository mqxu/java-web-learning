package com.mqxu.web.brand.service;

import com.mqxu.web.brand.pojo.Brand;
import com.mqxu.web.brand.pojo.PageBean;
import com.mqxu.web.brand.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description: BrandService接口单元测试
 * @author: mqxu
 * @date: 2022-03-04
 **/
class BrandServiceTest {
    private final BrandService brandService = new BrandServiceImpl();

    @Test
    void selectAll() {
        List<Brand> brands = brandService.selectAll();
        brands.forEach(System.out::println);
    }

    @Test
    void add() {
        Brand brand = new Brand();
        brand.setBrandName("测试品牌");
        brand.setCompanyName("测试品牌公司");
        brand.setDescription("测试品牌");
        brand.setOrdered(111);
        brand.setStatus(1);
        brandService.add(brand);
    }

    @Test
    void deleteByIds() {
        int[] ids = {65, 66, 69};
        brandService.deleteByIds(ids);
    }

    @Test
    void selectByPage() {
        PageBean<Brand> brandPageBean = brandService.selectByPage(2, 6);
        List<Brand> brands = brandPageBean.getRows();
        brands.forEach(System.out::println);
    }

    @Test
    void selectByPageAndCondition() {
        Brand brand = new Brand();
        brand.setBrandName("小米");
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(1, 10, brand);
        List<Brand> brands = brandPageBean.getRows();
        brands.forEach(System.out::println);

    }
}