package controller;

import service.WasteService;

import java.util.Scanner;

public class CollectorController {

    private final Scanner scanner;
    private final WasteService wasteService;

    public CollectorController(Scanner scanner, WasteService wasteService) {
        this.scanner = scanner;
        this.wasteService = wasteService;
    }

    public void start() {

        while (true) {
            System.out.println("\n1. View All Waste");
            System.out.println("2. Mark Collected");
            System.out.println("3. Category Summary");
            System.out.println("4. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> wasteService.getAllWaste().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Enter Waste ID: ");
                    try {
                        wasteService.markCollected(scanner.nextLine());
                        System.out.println("Marked as collected 🚛");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> wasteService.categorySummary()
                        .forEach((k, v) ->
                                System.out.println(k + " → " + v + "kg"));//THIS IS QQUIVALENT TO:-for(Map.Entry<WasteCategory,Double> entry : map.entrySet()){
                //System.out.println(entry.getKey() + "-->" + entry.getValue());
//}

                case 4 -> { return;
                                     }

            }
        }
    }
}
