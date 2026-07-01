package model;

import java.util.ArrayList;
import java.util.List;

public class Citizen {

    private final String name;
    private final List<WasteItem> submissions = new ArrayList<>();

    public Citizen(String name) {
        this.name = name;
    }

    public void addWaste(WasteItem item) {
        submissions.add(item);
    }

    public List<WasteItem> getSubmissions() {
        return submissions;
    }

}
