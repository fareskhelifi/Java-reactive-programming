package io.adad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    1. Introduction to programming paradigms
        - Imperative programming
        - Functional Programming (java 8, functional interface, lambda functions, streamAPI)

        --> some examples

    2. Reactive Programming Foundations
        - iterator pattern: allows sequential access to elements in a collection.
        - observer pattern: an object maintains a list of dependents that are notified of state changes
        - combining patterns: data is pushed to consumers as it becomes available

        --> demo of each pattern

        list.forEach(element -> System.out.println(element))

        clicksChannel.addObserver(event -> System.out.println(event))

        => combination:

        clicksChannel
        .filter(event -> event != null)
        .addObserver(event -> System.out.println(event))

        => reactive programming syntax

        clicksChannel
        .filter(event -> event != null)
        .subscribe(event -> System.out.println(event))

    3. Reactive Programming jargon and standardization
        - Publisher, Observable, Upstream, Producer
        - Subscriber, Observer, Sink, Downstream
        - Subscription
        - Processor

        - java 9
        - netflix and RxJava

    4. Reactive Programming in practice
        - Netty
        - Spring webflux

    --> 2 implementations examples (custom publisher and netty)
    --> finish with the blocking question to introduce threads and their functioning in reactive

    5. Asynchronous Non-blocking behavior
        - event loop: a single thread handle multiple tasks by delegating work and processing callbacks.
        - non-blocking I/O
        - callbacks

    Quiz !



 */

/*
    Non Blocking IO or Event loop behind the scenes
    As part of the event loop, we'll be having one thread and a queue. When you send requests about product Ids
    to reactor netty, these tasks will be added to the queue. The event loop thread will be continuously looking
    for tasks, if there are tasks in the queue they will be performed, otherwise it will be siting idle.
    When sending a task to a remote service, the thread wouldn't be siting idle waiting for task to be executed
    synchronously and get the response, instead it will pick up the next task and send the next request. This is something
    like throwing all the 100 balls in the air concurrently at the same time. So which one you'll be getting back first
    there is no guarantee for that (network latency, server load, ...). This is a very general problem in network issues.

    let's suppose a scenario:
    [1, 2, 3, 4, 5] : this is the outbound queue from which we'll be sending the requests
    lets suppose we've sent already 1 and 2, and we're now sending 3.
    we may get the response of 2, so the thread will be notified, and it will add it to the inbound queue for the
    incoming responses [2, 1]
    so one thread is enough to send 100 concurrent requests


    example:

    UserAdmin user = userService.getUserAdmin(userId);
    UserPreferences preferences = userPreferencesService.getPreferences(userId)

    open questions:
    why do we block in tests, in event we do delay Subscription ?
    why aren't any subscribe in the whole project
 */

public class Main {

    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("logger's fine");

    }
}