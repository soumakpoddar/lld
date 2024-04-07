package org.example;

import org.example.Observable.IPhoneObservableImpl;
import org.example.Observable.StocksObservable;
import org.example.Observer.EmailAlertObserverImpl;
import org.example.Observer.MobileAlertObserverImpl;
import org.example.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {

        StocksObservable iPhoneObservable = new IPhoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("soumak@gmail.com", iPhoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("soumak34@gmail.com", iPhoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("soumak's IPHONE", iPhoneObservable);

        iPhoneObservable.add(observer1);
        iPhoneObservable.add(observer2);
        iPhoneObservable.add(observer3);

        iPhoneObservable.setStockCount(10);
    }
}