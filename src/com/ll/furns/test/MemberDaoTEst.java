package com.ll.furns.test;

import com.ll.furns.dao.MemberDAO;
import com.ll.furns.dao.impl.MemberDAOImpl;
import com.ll.furns.entity.Member;
import com.ll.furns.service.MemberService;
import com.ll.furns.service.impl.MemberServiceImpl;
import org.junit.Test;

public class MemberDaoTEst {
    private MemberDAO memberDAO= new MemberDAOImpl() ;
    private MemberService memberService = new MemberServiceImpl();
    @Test
    public void queryMemberByUsername(){
        if(memberDAO.queryMemberByUsername("admin") == null){
            System.out.println("该用户不存在");
        }
        else
            System.out.println("操作成功");

    }
    @Test
    public void savaMember(){
        Member member = new Member(null, "king", "123", "king@sofu.com");
        if(memberDAO.saveMember(member) == 1){
            System.out.println("添加成功");
        }
        else
            System.out.println("添加失败");
    }

    @Test
    public void idExistsUsername(){
        if(memberService.isExistsUsername("adminz")){
            System.out.println("用户存在");
        }
        else
            System.out.println("用户不存在");
    }

    @Test
    public void regis(){
        Member member = new Member(null, "abc", "1234", "33@sofu,com");
        if(memberService.registerMember(member)){
            System.out.println("用户注册成功");
        }
        else
            System.out.println("注册失败");
    }

    @Test
    public void queryMemberByUsernameAndPassword(){
        Member member = memberDAO.queryMemberByUsernameAndPassword("jack", "1234");
        System.out.println(member);
    }
}
