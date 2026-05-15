package com.gym.service;

import com.gym.entity.MembershipPlan;
import com.gym.repository.MembershipPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    private final MembershipPlanRepository planRepository;

    public PlanService(MembershipPlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<MembershipPlan> getAllPlans() {
        return planRepository.findAll();
    }

    public void savePlan(MembershipPlan plan) {
        if (plan.getId() == null && planRepository.existsByPlanNameIgnoreCase(plan.getPlanName())) {
            throw new IllegalArgumentException("Plan name already exists.");
        }
        planRepository.save(plan);
    }

    public MembershipPlan getPlanById(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plan not found with id: " + id));
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}