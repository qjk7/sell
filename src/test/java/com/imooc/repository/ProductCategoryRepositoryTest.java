package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() throws Exception{

        Optional<ProductCategory> result = repository.findById(1001);
        System.out.println(result.toString());
    }

    //@Transactional 仅在测试类中标识 测试成功后回滚
    @Test
    @Transactional
    public void saveTest() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("学生最爱");
        ProductCategory result = repository.save(productCategory);
        //断言不为空，否则抛出异常
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<Integer> list = Arrays.asList(0,1,2);

        List<ProductCategory> result = repository.findByCategoryIdIn(list);
        Assert.assertNotEquals(0,result);
    }

}