package com.gym.controller;

import com.gym.entity.Member;
import com.gym.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("page", "members");
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("page", "members");
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/save")
    public String saveMember(@Valid @ModelAttribute("member") Member member,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "members");
            return "add-member";
        }

        try {
            memberService.saveMember(member);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("page", "members");
            model.addAttribute("error", ex.getMessage());
            return "add-member";
        }

        return "redirect:/members";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("page", "members");
        model.addAttribute("member", memberService.getMemberById(id));
        return "edit-member";
    }

    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable Long id,
                               @Valid @ModelAttribute("member") Member member,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "members");
            return "edit-member";
        }
        member.setId(id);
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}