package org.example.Observer;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String deviceId;

    public MobileAlertObserverImpl(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void update() {
        sendAppAlert(deviceId, "product is now in stock");
    }

    private void sendAppAlert(String deviceId, String message) {
        System.out.println("App Notification sent to " + deviceId + " that " + message);
    }
}
