package src.service;

import src.model.Deal;
import src.model.Item;
import src.model.Seller;
import src.model.TimeSlot;
import src.repository.DealRepository;
import src.repository.SellerRepository;

public class SellerService {
    public static final SellerService sellerService = new SellerService();

    private SellerService() {
    }

    public static SellerService getInstance() {
        return sellerService;
    }

    public Seller onboardSeller(String name) {
        Seller seller = new Seller(name);
        SellerRepository.save(seller);
        System.out.println(name + " onboarded");
        return seller;
    }

    public Deal createDeal(Seller seller, TimeSlot timeSlot, Item item, float price, int maxAllowed) {
        Deal deal = new Deal(seller, timeSlot, item, price, maxAllowed);
        DealRepository.save(deal);
        return deal;
    }

    public void endDeal(Deal deal) {
        if(isValidDeal(deal)) {
            DealRepository.setIsActiveFalse(deal);
            System.out.println(deal.getId() + " is ended");
        }
        else {
            System.out.println("Invalid deal");
            // throw exception InvalidDeal
        }
    }

    private boolean isValidDeal(Deal deal) {
        return DealRepository.dealMap.containsKey(deal.getId());
        // can seller validation (authorisation)
    }

    public void addItem(Deal deal, int count) {
        if(isValidDeal(deal)) {
            DealRepository.increamentCount(deal, count);
            System.out.println(deal.getId() + " count incremented to" + count);
        }
        else {
            System.out.println("Invalid deal");
            // throw exception InvalidDeal
        }
    }
}
