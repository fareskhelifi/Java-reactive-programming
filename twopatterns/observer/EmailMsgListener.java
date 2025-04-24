package io.adad.twopatterns.observer;

public class EmailMsgListener implements EventListener{
    private final String email;

    public EmailMsgListener(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(Event eventType) {
        System.out.println("Email sent to EmailMsgListener: " + email + " for " + eventType);
    }
}
