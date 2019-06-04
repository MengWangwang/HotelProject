package com.hotel3.service;


import com.hotel3.model.InOrder;
import com.hotel3.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InOrderService {

    public List<InOrder> getInOrderAll(InOrder inOrder);
    public int addInOrder(InOrder inOrder);
    public InOrder getOneInOrder(String inId);
    public int updateInOrderById(InOrder inOrder);
    public int deleteInOrderById(String inId);
    public int OverInOrder(String[] inIds,String status,String modifiedBy);

}
