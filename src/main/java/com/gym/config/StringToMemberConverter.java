package com.gym.config;

import com.gym.entity.Member;
import com.gym.service.MemberService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToMemberConverter implements Converter<String, Member> {

    private final MemberService memberService;

    public StringToMemberConverter(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public Member convert(String source) {
        if (source == null || source.isBlank()) {
            return null;
        }
        return memberService.getMemberById(Long.valueOf(source));
    }
}
