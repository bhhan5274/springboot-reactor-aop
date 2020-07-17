package com.bhhan.reactor.app.attachment.service.comment;

import com.bhhan.reactor.app.attachment.service.AttachService;
import com.bhhan.reactor.sharedmodel.attachment.Attachable;
import com.bhhan.reactor.sharedmodel.attachment.Attachment;
import com.bhhan.reactor.sharedmodel.attachment.AttachmentType;
import com.bhhan.reactor.sharedmodel.attachment.SimpleAttachmentCollection;
import com.bhhan.reactor.sharedmodel.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Service
@RequiredArgsConstructor
public class AttachCommentsToBoardService implements AttachService<BoardDto> {

    private static AttachmentType supportAttachmentType = AttachmentType.COMMENT;
    private Class<BoardDto> supportType = BoardDto.class;
    private final CommentClient commentClient;

    @Override
    public AttachmentType getSupportAttachmentType() {
        return supportAttachmentType;
}

    @Override
    public Class<BoardDto> getSupportType() {
        return supportType;
    }

    @Override
    public Attachment getAttachment(Attachable attachable) {
        final BoardDto boardDto = supportType.cast(attachable);
        return new SimpleAttachmentCollection<>(commentClient.getComments(boardDto.getId()));
    }
}
