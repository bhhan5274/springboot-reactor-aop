package com.bhhan.reactor.reactcore;

import com.bhhan.reactor.reactorcore.MySubscriber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class FluxTest{

    private final MySubscriber mySubscriber = new MySubscriber();

    @Test
    void test_flux_test(){
        final ArrayList<String> names = new ArrayList<>();
        final Flux<String> flux = Flux.just("에디킴", "아이린").log();
        flux.subscribe(names::add);
        assertEquals(Arrays.asList("에디킴", "아이린"), names);
    }

    @Test
    void test_flux_just_consumer(){
        List<String> names = new ArrayList<>();

        final Flux<String> flux = Flux.just("에디킴", "아이린").log();
        flux.subscribe(s -> {
            log.info("시퀀스 수신: {}", s);
            names.add(s);
        });
        assertEquals(Arrays.asList("에디킴", "아이린"), names);
    }

    @Test
    void test_flux_subscriber(){
        final Flux<String> flux = Flux.just("에디킴", "아이린").log();
        flux.subscribe(mySubscriber);
    }

    @Test
    void test_flux_lazy(){
        final Flux<Integer> flux = Flux.range(1, 9)
                .flatMap(n -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Mono.just(3 * n);
                }).log();

        log.info("No Subscription");
        flux.subscribe(value -> {
            log.info("value is : {}", value);
        }, null, () -> {log.info("데이터 수신 완료");});
        log.info("전체 완료");
    }
}