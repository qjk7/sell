package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1001");
        orderMaster.setBuyerName("北秋");
        orderMaster.setBuyerPhone("17863926155");
        orderMaster.setBuyerAddress("东软");
        orderMaster.setOrderId("108693");
        orderMaster.setOrderAmount(new BigDecimal(12.6));
        orderMaster.setBuyerOpenid("eopasndas103u4");

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest request = PageRequest.of(0,1);

        Page<OrderMaster> result = repository.findByBuyerOpenid("11011",request);
        Assert.assertNotEquals(0,result.getTotalElements());


    }
}