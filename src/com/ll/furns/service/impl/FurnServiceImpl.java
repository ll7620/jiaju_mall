package com.ll.furns.service.impl;

import com.ll.furns.dao.FurnDAO;
import com.ll.furns.dao.impl.FurnDAOImpl;
import com.ll.furns.entity.Furn;
import com.ll.furns.entity.Page;
import com.ll.furns.service.FurnService;

import java.util.List;

public class FurnServiceImpl implements FurnService {
    FurnDAO furnDAO = new FurnDAOImpl();
    @Override
    public List<Furn> queryFurns() {
        return furnDAO.queryFurns();
    }

    @Override
    public int add(Furn furn) {
        return furnDAO.add(furn);
    }

    @Override
    public int deleteFurnById(Integer id) {
        return furnDAO.deleteFurnById(id);
    }

    @Override
    public int updateFurnById(Furn furn) {
        return furnDAO.updateFurnById(furn);
    }

    @Override
    public Furn queryFurnById(Integer id) {
        return furnDAO.queryFurnById(id);
    }

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        Page<Furn> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getTotalRow();
        page.setTotalRow(totalRow);
        int pageTotalCount = totalRow / pageSize;
        if(totalRow % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        int begin = (pageNo - 1) * pageSize;
        List<Furn> pageItems = furnDAO.getPageItems(begin, pageSize);
        page.setItems(pageItems);

        return page;
    }

    @Override
    public Page<Furn> pageByName(int pageNo, int pageSize,String name) {
        Page<Furn> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getTotalRowByName(name);
        page.setTotalRow(totalRow);
        int pageTotalCount = totalRow / pageSize;
        if(totalRow % pageSize > 0){
            pageTotalCount += 1;
        }
        page.setPageTotalCount(pageTotalCount);
        int begin = (pageNo - 1) * pageSize;
        List<Furn> pageItems = furnDAO.getPageItemsByName(begin, pageSize,name);
        page.setItems(pageItems);

        return page;

    }


}
