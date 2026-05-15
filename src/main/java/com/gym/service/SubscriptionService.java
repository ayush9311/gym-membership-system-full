package com.gym.service;

import com.gym.entity.Subscription;
import com.gym.entity.SubscriptionStatus;
import com.gym.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> list = subscriptionRepository.findAll();
        list.forEach(Subscription::updateStatusBasedOnDate);
        return list;
    }

    public void saveSubscription(Subscription subscription) {
        subscription.calculateEndDate();
        subscriptionRepository.save(subscription);
    }

    public Subscription getSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found with id: " + id));
        subscription.updateStatusBasedOnDate();
        return subscription;
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public long getActiveSubscriptionCount() {
        return getAllSubscriptions().stream()
                .filter(s -> s.getStatus() == SubscriptionStatus.ACTIVE)
                .count();
    }

    public long getExpiredSubscriptionCount() {
        return getAllSubscriptions().stream()
                .filter(s -> s.getStatus() == SubscriptionStatus.EXPIRED)
                .count();
    }

    public double getEstimatedRevenue() {
        return getAllSubscriptions().stream()
                .filter(s -> s.getPlan() != null)
                .mapToDouble(s -> s.getPlan().getPrice())
                .sum();
    }
}