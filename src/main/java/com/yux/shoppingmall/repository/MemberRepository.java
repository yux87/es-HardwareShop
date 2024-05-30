package com.yux.shoppingmall.repository;

import com.yux.shoppingmall.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByUsername(String username);
}

