package com.bhhan.reactor.app.attachment.service.writer;

import com.bhhan.reactor.app.attachment.service.AttachService;
import com.bhhan.reactor.sharedmodel.attachment.Attachable;
import com.bhhan.reactor.sharedmodel.attachment.Attachment;
import com.bhhan.reactor.sharedmodel.attachment.AttachmentType;
import com.bhhan.reactor.sharedmodel.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Service
@RequiredArgsConstructor
public class AttachWriterToBoardService implements AttachService<BoardDto> {

    private final WriterClient writerClient;
    private AttachmentType supportAttachmentType = AttachmentType.WRITER;
    private Class<BoardDto> supportType = BoardDto.class;

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
        return writerClient.getWriter(boardDto.getWriterId());
    }
}
