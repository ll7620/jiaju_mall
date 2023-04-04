package com.ll.furns.test;

import com.ll.furns.dao.AdminDAO;
import com.ll.furns.dao.impl.AdminDAOImpl;
import com.ll.furns.entity.Admin;
import com.ll.furns.service.AdminService;
import com.ll.furns.service.impl.AdminServiceImpl;
import org.junit.Test;

public class AdminTest {

    AdminDAO adminDAO = new AdminDAOImpl();
    AdminService adminService = new AdminServiceImpl();

    @Test
    public void queryAdminD() {
        Admin admin = adminDAO.queryAdminByUsernameAndPassword("jack", "jack");
        System.out.println(admin);
    }

    @Test
    public void queryAdminS() {
        Admin admin = new Admin(null, "jack", "jack");
        Admin login = adminService.login(admin);
        System.out.println(login);
    }
}
