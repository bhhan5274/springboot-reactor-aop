package com.bhhan.reactor.reactivestream;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Slf4j
public class BhhanSubscription implements Subscription {
    private final ExecutorService executorService;
    private Subscriber<? super Integer> subscriber;
    private final AtomicInteger value;

    public BhhanSubscription(Subscriber<? super Integer> subscriber, ExecutorService executorService) {
        this.subscriber = subscriber;
        this.executorService = executorService;
        value = new AtomicInteger();
    }

    @Override
    public void request(long n) {
        if(n < 0) {
            return;
        }else{
            for(int i = 0; i < n; i++){
                executorService.execute(() -> {
                    int count = value.incrementAndGet();
                    if(count > 1000){
                        log.info("Item is over");
                        subscriber.onComplete();
                    }else{
                        log.info("push Item " + count);
                        subscriber.onNext(count);
                    }
                });
            }
        }
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
