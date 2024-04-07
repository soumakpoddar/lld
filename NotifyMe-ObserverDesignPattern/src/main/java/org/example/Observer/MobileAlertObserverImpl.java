package org.example.Observer;

import org.example.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String deviceId;
    StocksObservable observable;

    public MobileAlertObserverImpl(String deviceId, StocksObservable observable) {
        this.deviceId = deviceId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendAppAlert(deviceId, "product is now in stock");
    }

    private void sendAppAlert(String deviceId, String message) {
        System.out.println("App Notification sent to " + deviceId + " that " + message);
    }
}
