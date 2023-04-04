package com.ll.furns.service.impl;

import com.ll.furns.dao.MemberDAO;
import com.ll.furns.dao.impl.MemberDAOImpl;
import com.ll.furns.entity.Member;
import com.ll.furns.service.MemberService;

public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO = new MemberDAOImpl();

    @Override
    public boolean registerMember(Member member) {
        return memberDAO.saveMember(member) == 1 ? true : false;
    }

    @Override
    public boolean isExistsUsername(String username) {
        return memberDAO.queryMemberByUsername(username) == null ? false : true;
    }

    @Override
    public Member login(Member member) {
        return memberDAO.queryMemberByUsernameAndPassword(member.getUsername(),member.getPassword());
    }

}
