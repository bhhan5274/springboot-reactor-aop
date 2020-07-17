package com.bhhan.reactor.sharedmodel.board;

import com.bhhan.reactor.sharedmodel.attachment.Attachable;
import com.bhhan.reactor.sharedmodel.attachment.AttachmentWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardDto implements Attachable {
    @Setter(AccessLevel.PRIVATE)
    @JsonIgnore
    private AttachmentWrapper attachmentWrapper = new AttachmentWrapper();

    private Long id;
    private String title;
    private String content;

    @JsonIgnore
    private Long writerId;
}
