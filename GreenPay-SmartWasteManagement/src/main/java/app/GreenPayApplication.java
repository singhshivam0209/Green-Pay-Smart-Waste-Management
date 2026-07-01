package app;

import controller.*;
import service.*;
import java.util.Scanner;

public class GreenPayApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        WasteService wasteService = new WasteService();
        RewardService rewardService = new RewardService();

        CitizenController citizenController =
                new CitizenController(scanner, wasteService, rewardService);
        CollectorController collectorController =
                new CollectorController(scanner, wasteService);

        while (true) {
            System.out.println("\n🌴🎋🌴🎋🌴🌴 GREENPAY MAIN MENU");
            System.out.println("1. CITIZEN");
            System.out.println("2. COLLECTOR");
            System.out.println("3. EXIT");

            int choice = scanner.nextInt();
           scanner.nextLine();

            switch (choice) {
                case 1 -> citizenController.start();
                case 2 -> collectorController.start();
                case 3 -> {
                    System.out.println("SAVING PLANET, SIGNING OFF 🌍🌐🌎");
                    return;
                }
            }
        }
    }
}
