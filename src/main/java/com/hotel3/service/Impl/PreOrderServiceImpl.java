package com.hotel3.service.Impl;

import com.hotel3.mapper.PreOrderMapper;
import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import com.hotel3.service.PreOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PreOrderService")
public class PreOrderServiceImpl implements PreOrderService {

    @Resource(name="PreOrderMapper")
    private PreOrderMapper preOrderMapper;


    @Override
    public List<PreOrder> getPreOrderAll() {
        return preOrderMapper.getPerOrderAll();
    }

    @Override
    public int addPreOrder(PreOrder preOrder) {
        return preOrderMapper.addPerOrder(preOrder);
    }

    @Override
    public PreOrder getOnePreOrder(String inId) {
        return preOrderMapper.getOnePreOrder(inId);
    }

    @Override
    public int updatePreOrderById(PreOrder inOrder) {
        return preOrderMapper.updatePreOrderById(inOrder);
    }

    @Override
    public int deletePreOrderById(String inId) {
        return preOrderMapper.deletePreOrderById(inId);
    }
}
