package model;

public enum WasteCategory {

    RECYCLABLE(2.0, 5),
    REUSABLE(1.5, 3),
    HAZARDOUS(1.0, 1);

    private final double cashbackRate;
    private final int rewardPoints;

    WasteCategory(double cashbackRate, int rewardPoints) {
        this.cashbackRate = cashbackRate;
        this.rewardPoints = rewardPoints;
    }

    public double getCashbackRate() {
        return cashbackRate;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }
}
