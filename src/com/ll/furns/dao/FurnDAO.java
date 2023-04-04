package com.ll.furns.dao;

import com.ll.furns.entity.Furn;

import java.util.List;

public interface FurnDAO {
    public List<Furn> queryFurns();
    public int add(Furn furn);
    public int deleteFurnById(Integer id);
    public int updateFurnById(Furn furn);
    public Furn queryFurnById(Integer id);
    public int getTotalRow();
    public List<Furn> getPageItems(int begin, int pageSize);
    //public Furn getPageTotalCountByName(Furn furn);
    public int getTotalRowByName(String name);
    public List<Furn> getPageItemsByName(int begin, int pageSize,String name);

}