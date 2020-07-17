package com.bhhan.reactor.sharedmodel.attachment;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Collection;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
public interface AttachmentCollection<T extends Attachment> extends Attachment, Collection<T> {
    @JsonUnwrapped
    Collection<T> getValue();
}
