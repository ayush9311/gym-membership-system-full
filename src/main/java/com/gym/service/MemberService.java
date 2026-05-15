package com.gym.service;

import com.gym.entity.Member;
import com.gym.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void saveMember(Member member) {
        if (member.getId() == null && memberRepository.existsByEmail(member.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }
        memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + id));
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public long getActiveMemberCount() {
        return memberRepository.findAll()
                .stream()
                .filter(Member::isActive)
                .count();
    }
}