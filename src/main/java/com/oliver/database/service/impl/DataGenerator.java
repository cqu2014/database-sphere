package com.oliver.database.service.impl;

import com.oliver.database.entity.OrderEntity;
import com.oliver.database.entity.OrderItemEntity;
import com.oliver.database.service.IOrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Oliver Wang
 * @Description
 * @Created by IntelliJ IDEA 2018.
 * @Date Create at 2018/11/14 10:11
 */
@Component
public class DataGenerator {
    @Resource
    IOrderService iOrderService;

    public void generateData(int nums){
        while(nums-- >0){
            OrderEntity orderEntity = new OrderEntity();
            OrderItemEntity orderItemEntity = new OrderItemEntity();

            orderEntity.setUserId(100000-nums);
            orderEntity.setStatus("Waiting for paying");
            iOrderService.addOrder(orderEntity);

            orderItemEntity.setOrderId(100000L-nums);
            orderItemEntity.setUserId(orderEntity.getUserId());
        }
    }
}