package com.gym.controller;

import com.gym.service.MemberService;
import com.gym.service.PlanService;
import com.gym.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final MemberService memberService;
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    public HomeController(MemberService memberService,
                          PlanService planService,
                          SubscriptionService subscriptionService) {
        this.memberService = memberService;
        this.planService = planService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page", "dashboard");
        model.addAttribute("totalMembers", memberService.getAllMembers().size());
        model.addAttribute("totalPlans", planService.getAllPlans().size());
        model.addAttribute("totalSubscriptions", subscriptionService.getAllSubscriptions().size());
        model.addAttribute("activeMembers", memberService.getActiveMemberCount());
        model.addAttribute("activeSubscriptions", subscriptionService.getActiveSubscriptionCount());
        return "index";
    }
}