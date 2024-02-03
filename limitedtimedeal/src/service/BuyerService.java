package src.service;

import src.model.Buyer;
import src.model.Deal;
import src.model.TimeSlot;
import src.repository.BuyerHandler;
import src.repository.BuyerRepository;
import src.repository.DealRepository;

public class BuyerService {
    public static BuyerService buyerService = new BuyerService();
    private BuyerService() {

    }
    public  static BuyerService getInstance() {
        return buyerService;
    }

    public Buyer registerBuyer(String name, String address, String contactNumber) {
        Buyer buyer = new Buyer(name, address, contactNumber);
        BuyerRepository.save(buyer);
        System.out.println(buyer.getId() + "registered");
        return buyer;
    }

    synchronized public void claimDeal(Buyer buyer, Deal deal, int time) {
        if(canClaim(buyer, deal, time)) {
            DealRepository.deacrementMaxAllowed(deal);
            BuyerHandler.save(buyer, deal);
            System.out.println("Order placed for " + buyer.getName());
        }
    }

    private boolean canClaim(Buyer buyer, Deal deal, int time) {
        if(!deal.isActive()) {
            System.out.println(deal.getId() + " is not active");
            return false;
        }
        if(!isWithinPeriod(deal.getTimeSlot(), time)) {
            System.out.println(deal.getId() + " is not active");
            return false;
        }
        if(exceedLimit(buyer, deal)) {
            System.out.println(buyer.getId() + " has reached max limit allowed by seller");
            return false;
        }
        return true;
    }

    private boolean exceedLimit(Buyer buyer, Deal deal) {
        String key = buyer.getId()+deal.getId();
        if(BuyerHandler.map.containsKey(key)) {
            int claimCount = BuyerHandler.map.get(key);
            return claimCount >= deal.getMaxAllowed();
        }
        return false;
    }

    private boolean isWithinPeriod(TimeSlot timeSlot, int time) {
        return time >= timeSlot.getStart() && time <= timeSlot.getEnd();
    }
}
