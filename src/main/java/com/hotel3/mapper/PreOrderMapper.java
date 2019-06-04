package com.hotel3.mapper;

import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("PreOrderMapper")
public interface PreOrderMapper {

    public List<PreOrder> getPerOrderAll();

    public int addPerOrder(PreOrder preOrder);

    public PreOrder getOnePreOrder(@Param("preId") String preId);

    public int updatePreOrderById(PreOrder preOrder);

    public int deletePreOrderById(@Param("preId") String preId);

    public int OverPreOrder(@Param("PreIds") String[] PreIds,@Param("status") String status);
}