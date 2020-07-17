package com.bhhan.reactor.reactcore;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Slf4j
public class MonoTests {
    @Test
    void test_mono_just(){
        List<Signal<Integer>> signals = new ArrayList<>();

        final Integer[] result = new Integer[1];

        final Mono<Integer> mono = Mono.just(1).log()
                .doOnEach(integerSignal -> {
                    signals.add(integerSignal);
                    log.info("Signal... : " + integerSignal);
                });

        mono.subscribe(integer -> result[0] = integer);
        assertEquals(2, signals.size());
        assertEquals("ON_NEXT", signals.get(0).getType().name());
        assertEquals("ON_COMPLETE", signals.get(1).getType().name());
        assertEquals(1, result[0].intValue());
    }
}
