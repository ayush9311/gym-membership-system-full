package com.gym.controller;

import com.gym.dto.DashboardStatsDTO;
import com.gym.service.MemberService;
import com.gym.service.PlanService;
import com.gym.service.SubscriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardRestController {

    private final MemberService memberService;
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    public DashboardRestController(MemberService memberService,
                                   PlanService planService,
                                   SubscriptionService subscriptionService) {
        this.memberService = memberService;
        this.planService = planService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/stats")
    public DashboardStatsDTO getStats() {
        return new DashboardStatsDTO(
                memberService.getAllMembers().size(),
                memberService.getActiveMemberCount(),
                planService.getAllPlans().size(),
                subscriptionService.getAllSubscriptions().size(),
                subscriptionService.getActiveSubscriptionCount(),
                subscriptionService.getExpiredSubscriptionCount(),
                subscriptionService.getEstimatedRevenue() // ✅ FIXED (no null check)
        );
    }
}