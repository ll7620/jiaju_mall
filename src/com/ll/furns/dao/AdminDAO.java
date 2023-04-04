package com.ll.furns.dao;

import com.ll.furns.entity.Admin;

public interface AdminDAO {
    public Admin queryAdminByUsernameAndPassword(String username, String password);
}
