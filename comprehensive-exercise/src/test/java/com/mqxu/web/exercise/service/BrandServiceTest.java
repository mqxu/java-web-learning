package com.mqxu.web.exercise.service;

import com.mqxu.web.exercise.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-28
 **/
@Slf4j
class BrandServiceTest {

    private BrandService brandService;

    @BeforeEach
    void setUp() {
        brandService = new BrandService();
    }

    @Test
    void selectAll() {
        List<Brand> brands = brandService.selectAll();
        log.info(String.valueOf(brands));
        assertEquals(3, brands.size());
    }

    @Test
    void add() {
        Brand brand = Brand.builder()
                .brandName("测试品牌")
                .companyName("测试品牌公司")
                .ordered(0)
                .description("测试品牌公司")
                .status(1)
                .build();
        brandService.add(brand);
    }

    @Test
    void selectById() {
        Brand brand = brandService.selectById(1);
        assertNotNull(brand);
        log.info(String.valueOf(brand));
    }

    @Test
    void update() {
        Brand brand = brandService.selectById(4);
        brand.setStatus(0);
        brandService.update(brand);
    }
}