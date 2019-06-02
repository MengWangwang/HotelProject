package com.hotel3.mapper;

import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("PreOrderMapper")
public interface PreOrderMapper {

    public List<PreOrder> getPerOrderAll();

    public int addPerOrder(PreOrder inOrder);

    public PreOrder getOnePreOrder(@Param("inId") String inId);

    public int updatePreOrderById(PreOrder inOrder);

    public int deletePreOrderById(@Param("inId") String inId);
}