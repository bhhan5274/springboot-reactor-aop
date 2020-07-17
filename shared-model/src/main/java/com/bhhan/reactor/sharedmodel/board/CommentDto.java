package com.bhhan.reactor.sharedmodel.board;

import com.bhhan.reactor.sharedmodel.attachment.Attachment;
import lombok.Data;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Data
public class CommentDto implements Attachment {
    private Long id;
    private String email;
    private String body;
}
