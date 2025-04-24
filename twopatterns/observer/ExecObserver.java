package io.adad.twopatterns.observer;

public class ExecObserver {
    public static void main(String[] args) {
        Store store = new Store();
        store.getNotificationService().subscribe(
                Event.SALE,
                new EmailMsgListener("fares@gmail.com")
        );
        store.getNotificationService().subscribe(
                Event.NEW_ITEM,
                new MobileAppListener("Wafi")
        );

        store.newItemPromotion(Event.SALE);
    }
}
