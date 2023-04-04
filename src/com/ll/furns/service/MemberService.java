package com.ll.furns.service;

import com.ll.furns.entity.Member;

public interface MemberService {
    public boolean registerMember(Member member);
    public boolean isExistsUsername(String username);
    public Member login(Member member);
}
