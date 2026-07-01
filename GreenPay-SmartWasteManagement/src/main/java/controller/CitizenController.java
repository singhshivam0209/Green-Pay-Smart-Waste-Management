package controller;

import model.*;
import service.*;
import util.InputValidator;

import java.util.Scanner;

public class CitizenController {

    private final Scanner scanner;
    private final WasteService wasteService;
    private final RewardService rewardService;

    public CitizenController(Scanner scanner,
                             WasteService wasteService,
                             RewardService rewardService) {
        this.scanner = scanner;
        this.wasteService = wasteService;
        this.rewardService = rewardService;
    }

    public void start() {

        System.out.print("Enter Citizen Name: ");
        Citizen citizen = new Citizen(scanner.nextLine());

        while (true) {
            System.out.println("\n1. Add Waste");
            System.out.println("2. View Submissions");
            System.out.println("3. View Rewards");
            System.out.println("4. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addWaste(citizen);
                case 2 -> citizen.getSubmissions().forEach(System.out::println);
                case 3 -> showRewards(citizen);
                case 4 -> { return; }
            }
        }
    }

    private void addWaste(Citizen citizen) {
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        InputValidator.validateText(name);

        System.out.print("Quantity (kg): ");
        double qty = scanner.nextDouble();
        scanner.nextLine();
        InputValidator.validateQuantity(qty);

        System.out.print("Category (RECYCLABLE/REUSABLE/HAZARDOUS): ");
        WasteCategory category =
                WasteCategory.valueOf(scanner.nextLine().toUpperCase());

        WasteItem item = new WasteItem(name, qty, category);
        citizen.addWaste(item);
        wasteService.addWaste(item);

        System.out.println("Waste submitted successfully ✅");
    }

    private void showRewards(Citizen citizen) {
        System.out.println("Cashback ₹" +
                rewardService.calculateTotalCashback(citizen.getSubmissions()));
        System.out.println("Reward Points " +
                rewardService.calculateTotalRewardPoints(citizen.getSubmissions()));
    }
}
