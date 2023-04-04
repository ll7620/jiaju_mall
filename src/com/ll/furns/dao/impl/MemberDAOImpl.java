package com.ll.furns.dao.impl;

import com.ll.furns.dao.BasicDAO;
import com.ll.furns.dao.MemberDAO;
import com.ll.furns.entity.Member;

public class MemberDAOImpl extends BasicDAO<Member> implements MemberDAO {

    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "select * from member where username = ?";
        return querySingle(sql,Member.class,username);
    }

    @Override
    public int saveMember(Member member) {
        String sel = "insert into member (username, password, email )values (?,MD5(?),?)";
        return update(sel,member.getUsername(),member.getPassword(),member.getEmail());
    }

    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password){
        String sql = "select * from member where username = ? and password = MD5(?)";
        return querySingle(sql,Member.class,username,password);
    }
}
