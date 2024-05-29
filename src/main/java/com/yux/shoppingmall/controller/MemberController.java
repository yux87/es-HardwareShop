package com.yux.shoppingmall.controller;


import com.yux.shoppingmall.model.Member;
import com.yux.shoppingmall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable int memberId) {
        Optional<Member> member = memberService.findById(memberId);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member createdMember = memberService.save(member);
        return ResponseEntity.ok(createdMember);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable int memberId, @RequestBody Member memberDetails) {
        Optional<Member> optionalMember = memberService.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setMemberName(memberDetails.getMemberName());
            member.setEmail(memberDetails.getEmail());
            Member updatedMember = memberService.save(member);
            return ResponseEntity.ok(updatedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable int memberId) {
        memberService.deleteById(memberId);
        return ResponseEntity.noContent().build();
    }
}
