package com.imooc.service.Impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "10010";

    private final String ORDER_ID = "10010";

    @Test
    public void create() throws Exception{

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("北秋");
        orderDTO.setBuyerAddress("东软");
        orderDTO.setBuyerPhone("17863926155");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("10010");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findById() throws Exception{

        OrderDTO result = orderService.findById(ORDER_ID);
        log.info("[查询单个订单] result={}",result);
        System.out.println(result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() throws Exception {

        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,pageRequest);

        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel() throws Exception{

        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception{

        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.FINISH.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertNotEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void list() throws Exception {

        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);

//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        Assert.assertTrue("查询所有订单列表",orderDTOPage.getTotalElements() >0);

    }
}