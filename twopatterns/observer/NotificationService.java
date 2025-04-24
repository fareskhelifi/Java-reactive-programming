package io.adad.twopatterns.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    private final Map<Event, List<EventListener>> customers;

    public NotificationService() {
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event ->
            customers.put(event, new ArrayList<>())
        );
    }

    public Map<Event, List<EventListener>> getCustomers() {
        return customers;
    }

    public void subscribe(Event eventType, EventListener listener) {
        customers.get(eventType).add(listener);
    }

    public void unsubscribe(Event eventType, EventListener listener) {
        customers.get(eventType).remove(listener);
    }

    public void notifySubscriber(Event eventType) {
        customers.get(eventType).forEach(listener -> listener.update(eventType));
    }
}
