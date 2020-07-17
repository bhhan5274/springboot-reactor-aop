package com.bhhan.reactor.reactivestream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final BhhanPublisher bhhanPublisher = new BhhanPublisher();
        final BhhanSubscriber bhhanSubscriber = new BhhanSubscriber();
        final BhhanSubscriber bhhanSubscriber1 = new BhhanSubscriber();
        bhhanPublisher.subscribe(bhhanSubscriber);
        bhhanPublisher.subscribe(bhhanSubscriber1);
    }
}
