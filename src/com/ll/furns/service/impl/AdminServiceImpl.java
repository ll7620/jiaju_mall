package com.ll.furns.service.impl;

import com.ll.furns.dao.AdminDAO;
import com.ll.furns.dao.impl.AdminDAOImpl;
import com.ll.furns.entity.Admin;
import com.ll.furns.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDAO adminDAO = new AdminDAOImpl();
    @Override
    public Admin login(Admin admin) {
        return adminDAO.queryAdminByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }
}
