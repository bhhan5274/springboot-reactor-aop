package com.bhhan.reactor.reactorcore;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Slf4j
public class MySubscriber implements Subscriber<String> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        subscription = s;
        subscription.request(1);
    }

    @Override
    public void onNext(String s) {
        log.info("시퀀스 수신: " + s);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        log.info("에러: " + t.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("모든 시퀀스 수신 완료");
    }
}
