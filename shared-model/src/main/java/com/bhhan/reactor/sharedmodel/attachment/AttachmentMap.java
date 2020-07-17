package com.bhhan.reactor.sharedmodel.attachment;

import java.util.Map;
import java.util.Set;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
public interface AttachmentMap {
    void put(AttachmentType type, Attachment attachment);
    void putAll(Map<? extends AttachmentType, ? extends Attachment> attachmentMap);
    boolean isEmpty();
    Set<Map.Entry<AttachmentType, Attachment>> entrySet();
}
