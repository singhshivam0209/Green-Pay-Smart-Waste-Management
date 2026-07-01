package service;

import model.WasteItem;

import java.util.List;

public class RewardService {

    public double calculateTotalCashback(List<WasteItem> items) {
        return items.stream()
                .mapToDouble(i -> i.getQuantity() * i.getCategory().getCashbackRate())
                .sum();
    }

    public int calculateTotalRewardPoints(List<WasteItem> items) {
        return items.stream()
                .mapToInt(i -> (int)(i.getQuantity() * i.getCategory().getRewardPoints()))
                .sum();
    }
}
