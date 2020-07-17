package com.bhhan.reactor.app;

import com.bhhan.reactor.app.board.domain.Board;
import com.bhhan.reactor.app.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final List<Board> boards = IntStream.rangeClosed(1, 100)
                .mapToObj(n -> new Board("title" + n, "content" + n, (long) n))
                .collect(Collectors.toList());
        boardRepository.saveAll(boards);
    }
}
