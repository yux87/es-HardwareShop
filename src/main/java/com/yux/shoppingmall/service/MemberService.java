package com.yux.shoppingmall.service;

import com.yux.shoppingmall.model.Member;
import com.yux.shoppingmall.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findById(int memberId) {
        return memberRepository.findById(memberId);
    }

    @Transactional
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    public void deleteById(int memberId) {
        memberRepository.deleteById(memberId);
    }
}
