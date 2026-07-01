package model;

import java.util.UUID;

public class WasteItem {

    private final String id;
    private final String itemName;
    private final double quantity;
    private final WasteCategory category;
    private boolean collected;

    public WasteItem(String itemName, double quantity, WasteCategory category) {
        this.id = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
        this.collected = false;
    }

    public String getId() { return id; }
    public String getItemName() { return itemName; }
    public double getQuantity() { return quantity; }
    public WasteCategory getCategory() { return category; }
    public boolean isCollected() { return collected; }

    public void markCollected() {
        if (collected) {
            throw new IllegalStateException("Waste already collected");
        }
        this.collected = true;
    }

    @Override
    public String toString() {
        return id + " | " + itemName + " | " + category +
                " | " + quantity + "kg | Collected: " + collected;
    }
}
