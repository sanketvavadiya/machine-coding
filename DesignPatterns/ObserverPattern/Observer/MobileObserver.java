package ObserverPattern.Observer;

import ObserverPattern.Observable.IphoneObservable;
import ObserverPattern.Observable.MouseObservable;
import ObserverPattern.Observable.ObservableInterface;

public class MobileObserver implements ObserverInterface{
    ObservableInterface ob;

    public MobileObserver(ObservableInterface ob) {
        this.ob = ob;
    }
    @Override
    public void takeAction(ObservableInterface ob) {
        if(ob instanceof IphoneObservable)
            System.out.println("email sent for iphone");
        if(ob instanceof MouseObservable)
            System.out.println("email sent for mouse");
    }
}
