package com.ll.furns.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.ll.furns.dao.FurnDAO;
import com.ll.furns.dao.impl.FurnDAOImpl;
import com.ll.furns.entity.Furn;
import com.ll.furns.entity.Page;
import com.ll.furns.service.FurnService;
import com.ll.furns.service.impl.FurnServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.file.FileSystemLoopException;
import java.util.List;

public class FurnTest {
    private FurnDAO furnDAO = new FurnDAOImpl();
    private FurnService furnService = new FurnServiceImpl();
    @Test
    public void queryFurns(){
        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void queryFurnsService(){
        List<Furn> furns = furnService.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void add(){
        Furn furn = new Furn(null, "1213", "123", new BigDecimal(999.99), 100, 10, "123");
        int add = furnService.add(furn);
        System.out.println(add);
    }
    @Test
    public void de(){
        furnService.deleteFurnById(14);

    }
    @Test
    public void UPDAo(){
        Furn furn = new Furn(20, "1213", "123", new BigDecimal(999.99), 100, 10, "123");
        furnDAO.updateFurnById(furn);
    }
    @Test
    public void ueryFurById(){
        System.out.println(furnService.queryFurnById(17));
    }

    @Test
    public void g(){
        List<Furn> pageItems = furnDAO.getPageItems(0, 3);
        for (Furn pageItem : pageItems) {
            System.out.println(pageItem);
        }
    }

    @Test
    public void page(){
        Page<Furn> page = furnService.page(2,2);
        System.out.println(page);
    }
    @Test
    public void q(){
        Page<Furn> i = furnService.pageByName(1, 3, "温馨");
        System.out.println(i);

    }
}
