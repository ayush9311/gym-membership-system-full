package com.gym.controller;

import com.gym.entity.MembershipPlan;
import com.gym.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public String listPlans(Model model) {
        model.addAttribute("page", "plans");
        model.addAttribute("plans", planService.getAllPlans());
        return "plans";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("page", "plans");
        model.addAttribute("plan", new MembershipPlan());
        return "add-plan";
    }

    @PostMapping("/save")
    public String savePlan(@Valid @ModelAttribute("plan") MembershipPlan plan,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "plans");
            return "add-plan";
        }

        try {
            planService.savePlan(plan);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("page", "plans");
            model.addAttribute("error", ex.getMessage());
            return "add-plan";
        }

        return "redirect:/plans";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("page", "plans");
        model.addAttribute("plan", planService.getPlanById(id));
        return "edit-plan";
    }

    @PostMapping("/update/{id}")
    public String updatePlan(@PathVariable Long id,
                             @Valid @ModelAttribute("plan") MembershipPlan plan,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "plans");
            return "edit-plan";
        }
        plan.setId(id);
        planService.savePlan(plan);
        return "redirect:/plans";
    }

    @GetMapping("/delete/{id}")
    public String deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return "redirect:/plans";
    }
}