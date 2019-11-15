package com.imooc.service.Impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findById() throws Exception{
        ProductCategory productCategory = categoryService.findById(1001);
        System.out.println(productCategory);
        Assert.assertEquals(new Integer(1001),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception{
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> productCategoryList = categoryService.findByCategoryId(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,productCategoryList.size());

    }

    @Test
    public void save()  throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("学生最爱");
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}