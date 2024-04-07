package org.example.Observable;

import org.example.Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifyObservers();

    public void setStockCount(int newStockAdded);

    public int getStockCount();
}
