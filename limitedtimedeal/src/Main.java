package src;

import src.model.*;
import src.service.BuyerService;
import src.service.SellerService;

public class Main {
    public static  void main(String[] args) {
        SellerService sellerService = SellerService.getInstance();
        BuyerService buyerService = BuyerService.getInstance();

        Seller s1 = sellerService.onboardSeller("s1");
        Seller s2 = sellerService.onboardSeller("s2");
        Buyer b1 = buyerService.registerBuyer("b1", "abc", "123");
        Buyer b2 = buyerService.registerBuyer("b2", "abc", "123");

        Item i1 = new Item("i1", 12);

        Deal d1 = sellerService.createDeal(s1, new TimeSlot(900, 1000), i1, 15, 2);
        Deal d2 = sellerService.createDeal(s2, new TimeSlot(900, 1000), i1, 25, 2);
        buyerService.claimDeal(b1, d1, 930); // valid puchase
        buyerService.claimDeal(b1, d1, 1100); // deal expired
        buyerService.claimDeal(b1, d1, 940); // valid purchase
        buyerService.claimDeal(b1, d1, 910); // max limit reached
    }
}
