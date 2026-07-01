package greenpay;

import model.*;
import service.WasteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WasteServiceTest {

    @Test
    void markCollectedSuccess() {
        WasteService service = new WasteService();
        WasteItem item =
                new WasteItem("Battery", 2, WasteCategory.HAZARDOUS);
        service.addWaste(item);
        service.markCollected(item.getId());
        assertTrue(item.isCollected());
    }

    @Test
    void doubleCollectionThrowsException() {
        WasteService service = new WasteService();
        WasteItem item =
                new WasteItem("Battery", 2, WasteCategory.HAZARDOUS);
        service.addWaste(item);
        service.markCollected(item.getId());
        assertThrows(IllegalStateException.class,
                () -> service.markCollected(item.getId()));
    }
}
