package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("10013");
        productInfo.setProductName("香草");
        productInfo.setProductPrice(new BigDecimal(14));
        productInfo.setProductStock(10);
        productInfo.setProductIcon("https://xxx.jpg");
        productInfo.setProductDescription("丝滑");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo info = repository.save(productInfo);
        Assert.assertNotNull(info);
    }

    @Test
    public void findByProductStatus() throws Exception{

        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotNull(list);

    }
}