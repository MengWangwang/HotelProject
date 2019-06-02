package com.hotel3.mapper;

import com.hotel3.model.InOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("InOrderMapper")
public interface InOrderMapper {

    public List<InOrder> getInOrderAll(InOrder inOrder);

    public int addInOrder(InOrder inOrder);

    public InOrder getOneInOrder(@Param("inId") String inId);

    public int updateInOrderById(InOrder inOrder);

    public int deleteInOrderById(@Param("inId") String inId);
}