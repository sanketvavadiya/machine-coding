package src.repository;

import src.model.Buyer;

import java.util.HashMap;
import java.util.Map;

public class BuyerRepository {
    public static Map<String, Buyer> buyerMap = new HashMap<>();
    public static void save(Buyer buyer) {
        buyerMap.put(buyer.getId(), buyer);
    }
}
