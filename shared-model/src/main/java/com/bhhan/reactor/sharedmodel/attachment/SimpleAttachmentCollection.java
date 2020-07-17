package com.bhhan.reactor.sharedmodel.attachment;

import lombok.Value;
import lombok.experimental.Delegate;
import java.util.Collection;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
@Value
public class SimpleAttachmentCollection<T extends Attachment> implements AttachmentCollection<T> {
    @Delegate
    private Collection<T> value;
}
