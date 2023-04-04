package com.ll.furns.dao.impl;

import com.ll.furns.dao.AdminDAO;
import com.ll.furns.dao.BasicDAO;
import com.ll.furns.entity.Admin;

public class AdminDAOImpl extends BasicDAO<Admin> implements AdminDAO {
    @Override
    public Admin queryAdminByUsernameAndPassword(String username, String password) {
        String sql = "select * from admin where username = ? and password = ?";
        return  querySingle(sql,Admin.class,username,password);
    }
}
