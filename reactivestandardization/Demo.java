package io.adad.reactivestandardization;

/*
    1. publisher does not produce data until subscriber requests for it.
    2. publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
    3. subscriber can cancel the subscription. producer should stop at that moment as subscriber is no longer
       interested in consuming the data
    4. producer can send the error signal to indicate something is wrong
 */

import io.adad.common.Util;
import io.adad.reactivestandardization.publisher.PublisherImpl;
import io.adad.reactivestandardization.subscriber.SubscriberImpl;
import reactor.core.publisher.Flux;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        demo2();
        Flux.just(1,2,3,4)
                .subscribe(Util.subscriber());
    }

    public static void demo1() {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    public static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);

    }

    public static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
    }

    public static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(20);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
    }

}
