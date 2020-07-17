package com.bhhan.reactor.sharedmodel.attachment;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
public class AttachmentWrapper implements AttachmentMap {
    private Map<AttachmentType, Attachment> map = new EnumMap<AttachmentType, Attachment>(AttachmentType.class);

    @Override
    public void put(AttachmentType type, Attachment attachment) {
        map.put(type, attachment);
    }

    @Override
    public void putAll(Map<? extends AttachmentType, ? extends Attachment> attachmentMap) {
        map.putAll(attachmentMap);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Set<Map.Entry<AttachmentType, Attachment>> entrySet() {
        return map.entrySet();
    }
}
