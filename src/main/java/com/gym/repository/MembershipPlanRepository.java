package com.gym.repository;

import com.gym.entity.MembershipPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipPlanRepository extends JpaRepository<MembershipPlan, Long> {
    boolean existsByPlanNameIgnoreCase(String planName);
}
