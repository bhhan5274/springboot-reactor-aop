package com.bhhan.reactor.app.attachment;

import com.bhhan.reactor.sharedmodel.attachment.AttachmentType;

import java.util.Collections;
import java.util.Set;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */
public class AttachmentTypeHolder {
    private static ThreadLocal<Set<AttachmentType>> context = new ThreadLocal<>();

    public static void setTypes(Set<AttachmentType> types){
        context.set(Collections.unmodifiableSet(types));
    }

    public static boolean isEmpty(){
        final Set<AttachmentType> attachmentTypes = context.get();
        return attachmentTypes == null || attachmentTypes.isEmpty();
    }

    public static Set<AttachmentType> getTypes(){
        return context.get();
    }
}
