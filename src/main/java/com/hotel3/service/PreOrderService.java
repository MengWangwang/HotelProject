package com.hotel3.service;


import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;

import java.util.List;

public interface PreOrderService {

    public List<PreOrder> getPreOrderAll();
    public int addPreOrder(PreOrder inOrder);
    public PreOrder getOnePreOrder(String inId);
    public int updatePreOrderById(PreOrder preOrder);
    public int deletePreOrderById(String inId);

}
