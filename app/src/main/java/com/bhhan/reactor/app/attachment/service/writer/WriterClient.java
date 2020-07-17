package com.bhhan.reactor.app.attachment.service.writer;

import com.bhhan.reactor.sharedmodel.board.WriterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@FeignClient(name = "writer-api", url = "https://jsonplaceholder.typicode.com")
public interface WriterClient {
    @GetMapping("/users/{id}")
    WriterDto getWriter(@PathVariable("id") Long id);
}
