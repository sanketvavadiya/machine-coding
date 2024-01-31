package ObserverPattern.Observable;

import ObserverPattern.Observer.ObserverInterface;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements ObservableInterface {
    List<ObserverInterface> observers;
    int stockCount;

    public IphoneObservable() {
        observers = new ArrayList<>();
        stockCount = 0;
    }

    @Override
    public void addObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        // remove observer;
    }

    @Override
    public void notifyObservers() {
        for(ObserverInterface ob : observers) {
            ob.takeAction(this);
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
        notifyObservers();
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
