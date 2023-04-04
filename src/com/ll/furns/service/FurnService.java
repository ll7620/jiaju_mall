package com.ll.furns.service;

import com.ll.furns.entity.Furn;
import com.ll.furns.entity.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface FurnService {
    public List<Furn> queryFurns();

    public int add(Furn furn);

    public int deleteFurnById(Integer id);

    public int updateFurnById(Furn furn);

    public Furn queryFurnById(Integer id);

    public Page<Furn> page(int pageNo, int pageSize);
    public Page<Furn> pageByName(int pageNo, int pageSize, String name);
}
