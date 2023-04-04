package com.ll.furns.dao.impl;

import com.ll.furns.dao.BasicDAO;
import com.ll.furns.dao.FurnDAO;
import com.ll.furns.entity.Furn;

import java.util.List;

public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {
    @Override
    public List<Furn> queryFurns() {
        String sql = "select id, name, maker, price, sales,stock,img_path as imgpath from furn";
        return queryMulti(sql, Furn.class);
    }

    @Override
    public int add(Furn furn) {
        String sql = " INSERT INTO furn(`id` , `name` , `maker` , `price` , `sales` , `stock` , `img_path`)" +
                "VALUES(NULL , ?,?,?,?,?,?);";
        return update(sql, furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(), furn.getImgPath());

    }

    @Override
    public int deleteFurnById(Integer id) {
        String sql = "delete from furn where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateFurnById(Furn furn) {
        String sql = "update furn set `id` = ? , `name` =  ?, `maker`  = ?, `price` =  ?, `sales` = ?, `stock` =  ?, `img_path` =? where id = ? ";
        return update(sql, furn.getId(),furn.getName(), furn.getMaker(), furn.getPrice(), furn.getSales(), furn.getStock(), furn.getImgPath(),furn.getId());
    }

    @Override
    public Furn queryFurnById(Integer id) {
        String sql = "select id, name, maker, price, sales,stock,img_path as imgpath from furn where id = ?";
        return querySingle(sql,Furn.class,id);
    }

    @Override
    public int getTotalRow() {
        String sql = "SELECT count(*) FROM `furn`";
        //return queryScalar(sql);
        return ((Number)queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int begin, int pageSize) {
        String sql = "select id, name, maker, price, sales,stock,img_path as imgpath from furn limit ?,?";
        return queryMulti(sql,Furn.class,begin,pageSize);
    }

  /*  @Override
    public Furn getPageTotalCountByName(Furn furn) {
        String sql = "select id, name, maker, price, sales,stock,img_path as imgpath from furn where name = ?";
        return querySingle(sql,Furn.class,furn.getName());
    }*/

    @Override
    public int getTotalRowByName(String name) {
        String sql = "SELECT count(*) FROM `furn` where name like ?";

        return ((Number)queryScalar(sql, "%"+name+"%")).intValue();
    }

    @Override
    public List<Furn> getPageItemsByName(int begin, int pageSize,String name) {
        String sql = "select id, name, maker, price, sales,stock,img_path as imgpath from furn where name like ? limit ?,?";
        return queryMulti(sql,Furn.class,"%"+name+"%",begin,pageSize);

    }

}


