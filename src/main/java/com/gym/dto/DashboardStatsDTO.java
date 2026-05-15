package com.gym.dto;

public class DashboardStatsDTO {

    private long totalMembers;
    private long activeMembers;
    private long totalPlans;
    private long totalSubscriptions;
    private long activeSubscriptions;
    private long expiredSubscriptions;
    private double estimatedRevenue;

    public DashboardStatsDTO() {
    }

    public DashboardStatsDTO(long totalMembers, long activeMembers, long totalPlans,
                             long totalSubscriptions, long activeSubscriptions,
                             long expiredSubscriptions, double estimatedRevenue) {
        this.totalMembers = totalMembers;
        this.activeMembers = activeMembers;
        this.totalPlans = totalPlans;
        this.totalSubscriptions = totalSubscriptions;
        this.activeSubscriptions = activeSubscriptions;
        this.expiredSubscriptions = expiredSubscriptions;
        this.estimatedRevenue = estimatedRevenue;
    }

    public long getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(long totalMembers) {
        this.totalMembers = totalMembers;
    }

    public long getActiveMembers() {
        return activeMembers;
    }

    public void setActiveMembers(long activeMembers) {
        this.activeMembers = activeMembers;
    }

    public long getTotalPlans() {
        return totalPlans;
    }

    public void setTotalPlans(long totalPlans) {
        this.totalPlans = totalPlans;
    }

    public long getTotalSubscriptions() {
        return totalSubscriptions;
    }

    public void setTotalSubscriptions(long totalSubscriptions) {
        this.totalSubscriptions = totalSubscriptions;
    }

    public long getActiveSubscriptions() {
        return activeSubscriptions;
    }

    public void setActiveSubscriptions(long activeSubscriptions) {
        this.activeSubscriptions = activeSubscriptions;
    }

    public long getExpiredSubscriptions() {
        return expiredSubscriptions;
    }

    public void setExpiredSubscriptions(long expiredSubscriptions) {
        this.expiredSubscriptions = expiredSubscriptions;
    }

    public double getEstimatedRevenue() {
        return estimatedRevenue;
    }

    public void setEstimatedRevenue(double estimatedRevenue) {
        this.estimatedRevenue = estimatedRevenue;
    }
}