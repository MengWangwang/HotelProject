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
    public PreOrder getOnePreOrder(String preId) {
        return preOrderMapper.getOnePreOrder(preId);
    }

    @Override
    public int updatePreOrderById(PreOrder preOrder) {
        return preOrderMapper.updatePreOrderById(preOrder);
    }

    @Override
    public int deletePreOrderById(String preId) {
        return preOrderMapper.deletePreOrderById(preId);
    }

    @Override
    public int OverPreOrder(String[] PreIds, String status) {
        return preOrderMapper.OverPreOrder(PreIds,status);
    }
}
