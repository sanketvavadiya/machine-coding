package ObserverPattern.Observable;

import ObserverPattern.Observer.ObserverInterface;

public interface ObservableInterface {
    void addObserver(ObserverInterface observer);
    void removeObserver(ObserverInterface observer);
    void notifyObservers();
    void setStockCount(int stockCount);
    int getStockCount();
}
