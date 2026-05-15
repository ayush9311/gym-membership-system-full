package com.gym.config;

import com.gym.entity.MembershipPlan;
import com.gym.service.PlanService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPlanConverter implements Converter<String, MembershipPlan> {

    private final PlanService planService;

    public StringToPlanConverter(PlanService planService) {
        this.planService = planService;
    }

    @Override
    public MembershipPlan convert(String source) {
        if (source == null || source.isBlank()) {
            return null;
        }
        return planService.getPlanById(Long.valueOf(source));
    }
}
