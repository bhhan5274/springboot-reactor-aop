package com.bhhan.reactor.app.attachment.service;

import com.bhhan.reactor.sharedmodel.attachment.Attachable;
import com.bhhan.reactor.sharedmodel.attachment.Attachment;
import com.bhhan.reactor.sharedmodel.attachment.AttachmentType;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
public interface AttachService<T extends Attachable> {
    AttachmentType getSupportAttachmentType();
    Class<T> getSupportType();
    Attachment getAttachment(Attachable attachable);
}
