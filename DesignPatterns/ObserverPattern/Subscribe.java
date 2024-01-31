package ObserverPattern;

import ObserverPattern.Observable.IphoneObservable;
import ObserverPattern.Observable.MouseObservable;
import ObserverPattern.Observer.EmailObserver;
import ObserverPattern.Observer.MobileObserver;

public class Subscribe {
    public static void main(String[] args) {
        IphoneObservable iphoneObservable = new IphoneObservable();
        EmailObserver emailObserver1 = new EmailObserver(iphoneObservable);
        MobileObserver mobileObserver1 = new MobileObserver(iphoneObservable);

        iphoneObservable.addObserver(emailObserver1);
        iphoneObservable.addObserver(mobileObserver1);
        iphoneObservable.setStockCount(8);

        MouseObservable mouseObservable = new MouseObservable();
        mouseObservable.addObserver(new EmailObserver(mouseObservable));
        mouseObservable.addObserver(new MobileObserver(mouseObservable));
        mouseObservable.setStockCount(10);
    }
}
