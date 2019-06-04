package com.hotel3.service;


import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PreOrderService {

    public List<PreOrder> getPreOrderAll();
    public int addPreOrder(PreOrder preOrder);
    public PreOrder getOnePreOrder(String preId);
    public int updatePreOrderById(PreOrder preOrder);
    public int deletePreOrderById(String preId);
    public int OverPreOrder(String[] roomIds,String status);

}
