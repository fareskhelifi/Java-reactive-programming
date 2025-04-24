package io.adad.twopatterns.observer;

public class MobileAppListener implements EventListener {
    private final String username;

    public MobileAppListener(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void update(Event eventType) {
        System.out.println("Message sent to MobileAppListener: " + username + " for " + eventType);
    }
}
