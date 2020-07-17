package com.bhhan.reactor.app.attachment.service.comment;

import com.bhhan.reactor.sharedmodel.board.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@FeignClient(name = "comment-api", url = "https://jsonplaceholder.typicode.com")
public interface CommentClient {
    @GetMapping("/comments")
    List<CommentDto> getComments(@RequestParam("postId") Long boardId);
}
