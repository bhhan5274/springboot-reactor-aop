package com.bhhan.reactor.sharedmodel.attachment;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
public interface Attachable {
    AttachmentWrapper getAttachmentWrapper();

    default void attach(AttachmentType type, Attachment attachment){
        getAttachmentWrapper()
                .put(type, attachment);
    }

    default void attach(Map<? extends AttachmentType, ? extends Attachment> attachment){
        getAttachmentWrapper().putAll(attachment);
    }

    @JsonAnyGetter
    default Map<String, Object> getAttachment(){
        final AttachmentWrapper attachmentWrapper = getAttachmentWrapper();

        if(attachmentWrapper.isEmpty()){
            return null;
        }

        return attachmentWrapper.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().lowerCaseName(), Map.Entry::getValue));
    }
}
