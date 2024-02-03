package src.repository;

import src.model.Deal;

import java.util.HashMap;
import java.util.Map;

public class DealRepository {
    public static Map<String, Deal> dealMap = new HashMap<>();

    private DealRepository() {

    }

    public static void save(Deal deal) {
        dealMap.put(deal.getId(), deal);
    }

    public static void setIsActiveFalse(Deal deal) {
        deal.setActive(false);
    }

    public static void increamentCount(Deal deal, int count) {
        int currCount = deal.getMaxAllowed();
        deal.setMaxAllowed(currCount+count);
    }

    public static void deacrementMaxAllowed(Deal deal) {
        int maxAllowed = deal.getMaxAllowed();
        deal.setMaxAllowed(maxAllowed - 1);
        if(deal.getMaxAllowed() == 0)
            deal.setActive(false);
    }
}
