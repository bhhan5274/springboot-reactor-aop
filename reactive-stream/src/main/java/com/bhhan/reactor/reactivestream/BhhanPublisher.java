package com.bhhan.reactor.reactivestream;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Slf4j
public class BhhanPublisher implements Publisher<Integer> {
    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        log.info("publisher - subscribe");
        subscriber.onSubscribe(new BhhanSubscription(subscriber, executorService));
    }
}
