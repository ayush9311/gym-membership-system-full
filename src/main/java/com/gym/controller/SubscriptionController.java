package com.gym.controller;

import com.gym.entity.PaymentStatus;
import com.gym.entity.Subscription;
import com.gym.entity.SubscriptionStatus;
import com.gym.service.MemberService;
import com.gym.service.PlanService;
import com.gym.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final MemberService memberService;
    private final PlanService planService;

    public SubscriptionController(SubscriptionService subscriptionService,
                                  MemberService memberService,
                                  PlanService planService) {
        this.subscriptionService = subscriptionService;
        this.memberService = memberService;
        this.planService = planService;
    }

    @GetMapping
    public String listSubscriptions(Model model) {
        model.addAttribute("page", "subscriptions");
        model.addAttribute("subscriptions", subscriptionService.getAllSubscriptions());
        return "subscriptions";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("page", "subscriptions");
        model.addAttribute("subscription", new Subscription());
        model.addAttribute("members", memberService.getAllMembers());
        model.addAttribute("plans", planService.getAllPlans());
        model.addAttribute("paymentStatuses", PaymentStatus.values());
        model.addAttribute("subscriptionStatuses", SubscriptionStatus.values());
        return "add-subscription";
    }

    @PostMapping("/save")
    public String saveSubscription(@Valid @ModelAttribute("subscription") Subscription subscription,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "subscriptions");
            model.addAttribute("members", memberService.getAllMembers());
            model.addAttribute("plans", planService.getAllPlans());
            model.addAttribute("paymentStatuses", PaymentStatus.values());
            model.addAttribute("subscriptionStatuses", SubscriptionStatus.values());
            return "add-subscription";
        }
        subscriptionService.saveSubscription(subscription);
        return "redirect:/subscriptions";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return "redirect:/subscriptions";
    }
}