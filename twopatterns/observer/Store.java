package io.adad.twopatterns.observer;

/*
    Observer Design Pattern
    - behavioral design pattern
    - notifies multiple objects, or subscribers, about any events that happen to the object they're observing, or publisher
    - allows you to change or take action on a set of objects when and if the state of another object changes
        -> this can be done even if the modifiable set of objects is unknown beforehand or changes dynamically.
    - you can introduce new subscriber classes without having to change the publisher's code, and vice versa
    if there's a publisher interface
 */

public class Store {
    private final NotificationService notificationService;

    public Store() {
        notificationService = new NotificationService();
    }

    public void newItemPromotion(Event eventType) {
        notificationService.notifySubscriber(eventType);
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
