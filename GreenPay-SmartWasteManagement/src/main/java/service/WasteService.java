package service;

import model.WasteCategory;
import model.WasteItem;

import java.util.*;
import java.util.stream.Collectors;

public class WasteService {

    private final List<WasteItem> allWaste = new ArrayList<>();

    public void addWaste(WasteItem item) {//this is the getter method.
        allWaste.add(item);
    }

    public Optional<WasteItem> findById(String id) {
        return allWaste.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst();//if no matching id will be found it will return the special type of object called as Optional.empty().
    }

    public void markCollected(String id) {
        WasteItem item = findById(id)
                .orElseThrow(() -> new NoSuchElementException("Waste not found"));
        item.markCollected();
    }

    public Map<WasteCategory, Double> categorySummary() {
        return allWaste.stream()
                .collect(Collectors.groupingBy(
                        WasteItem::getCategory,
                        Collectors.summingDouble(WasteItem::getQuantity)
                ));
    }

    public List<WasteItem> getAllWaste() {
        return allWaste;
    }
}
