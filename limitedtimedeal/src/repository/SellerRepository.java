package src.repository;

import src.model.Seller;

import java.util.HashMap;
import java.util.Map;

public class SellerRepository {
    public static Map<String, Seller> sellerMap = new HashMap<>();
    public static void save(Seller seller) {
        sellerMap.put(seller.getId(), seller);
    }
}
