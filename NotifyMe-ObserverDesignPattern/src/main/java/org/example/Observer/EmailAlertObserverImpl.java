package org.example.Observer;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;

    public EmailAlertObserverImpl(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendEmail(emailId, "product is now in stock");
    }

    private void sendEmail(String emailId, String message) {
        System.out.println("Email sent to " + emailId + " that " + message);
    }
}
