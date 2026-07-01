package greenpay;

import model.*;
import service.RewardService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RewardServiceTest {

    @Test
    void cashbackCalculationWorks() {
        RewardService service = new RewardService();
        List<WasteItem> list =
                List.of(new WasteItem("Plastic", 10, WasteCategory.RECYCLABLE));
        assertEquals(20.0, service.calculateTotalCashback(list));
    }

    @Test
    void rewardPointsCalculationWorks() {
        RewardService service = new RewardService();
        List<WasteItem> list =
                List.of(new WasteItem("Glass", 5, WasteCategory.REUSABLE));
        assertEquals(15, service.calculateTotalRewardPoints(list));
    }
}
