package com.gym.config;

import com.gym.entity.*;
import com.gym.repository.MemberRepository;
import com.gym.repository.MembershipPlanRepository;
import com.gym.repository.SubscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final MembershipPlanRepository planRepository;
    private final SubscriptionRepository subscriptionRepository;

    public DataLoader(MemberRepository memberRepository,
                      MembershipPlanRepository planRepository,
                      SubscriptionRepository subscriptionRepository) {
        this.memberRepository = memberRepository;
        this.planRepository = planRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void run(String... args) {
        if (memberRepository.count() == 0) {
            Member m1 = new Member();
            m1.setFullName("Ayush Kumar Singh");
            m1.setEmail("ayush@example.com");
            m1.setPhone("9876543210");
            m1.setGender("Male");
            m1.setAge(21);
            m1.setJoinDate(LocalDate.now().minusDays(10));
            m1.setActive(true);
            memberRepository.save(m1);

            Member m2 = new Member();
            m2.setFullName("Riya Sharma");
            m2.setEmail("riya@example.com");
            m2.setPhone("9123456780");
            m2.setGender("Female");
            m2.setAge(22);
            m2.setJoinDate(LocalDate.now().minusDays(5));
            m2.setActive(true);
            memberRepository.save(m2);
        }

        if (planRepository.count() == 0) {
            MembershipPlan p1 = new MembershipPlan();
            p1.setPlanName("Monthly Plan");
            p1.setDurationInMonths(1);
            p1.setPrice(999);
            p1.setDescription("Basic monthly membership plan");
            planRepository.save(p1);

            MembershipPlan p2 = new MembershipPlan();
            p2.setPlanName("Quarterly Plan");
            p2.setDurationInMonths(3);
            p2.setPrice(2499);
            p2.setDescription("3-month gym membership plan");
            planRepository.save(p2);
        }

        if (subscriptionRepository.count() == 0 && memberRepository.count() > 0 && planRepository.count() > 0) {
            Subscription s1 = new Subscription();
            s1.setMember(memberRepository.findAll().get(0));
            s1.setPlan(planRepository.findAll().get(0));
            s1.setStartDate(LocalDate.now().minusDays(2));
            s1.setPaymentStatus(PaymentStatus.PAID);
            s1.setStatus(SubscriptionStatus.ACTIVE);
            s1.calculateEndDate();
            subscriptionRepository.save(s1);
        }
    }
}
