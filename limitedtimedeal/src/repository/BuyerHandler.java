package src.repository;

import src.model.Buyer;
import src.model.Deal;

import java.util.HashMap;
import java.util.Map;

public class BuyerHandler {
    public static Map<String, Integer> map = new HashMap<>();
    public static void save(Buyer buyer, Deal deal) {
        String key = buyer.getId() + deal.getId();
//        if(map.containsKey(key)) {
//            int calimed = map.get(key);
//            map.put(key, calimed+1);
//        }
//        map.put(key, 1);
        map.put(key, map.getOrDefault(map.get(key), 0)+1);
    }
}
