package com.bhhan.reactor.app.config.aop;

import com.bhhan.reactor.app.attachment.AttachmentTypeHolder;
import com.bhhan.reactor.app.attachment.service.AttachService;
import com.bhhan.reactor.sharedmodel.attachment.Attachable;
import com.bhhan.reactor.sharedmodel.attachment.Attachment;
import com.bhhan.reactor.sharedmodel.attachment.AttachmentType;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Component
@Aspect
public class AttachmentAspect {
    private final Map<AttachmentType, List<AttachService<? extends Attachable>>> typeToServiceMap;

    @Autowired
    public AttachmentAspect(List<AttachService<? extends Attachable>> attachServices){
        this.typeToServiceMap = attachServices.stream()
                .collect(Collectors.groupingBy(AttachService::getSupportAttachmentType));
    }

    @Pointcut("@annotation(com.bhhan.reactor.app.attachment.Attach)")
    private void pointcut(){}

    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public Object afterReturning(Object returnValue){
        if(AttachmentTypeHolder.isEmpty() || !(returnValue instanceof Attachable)){
            return returnValue;
        }

        executeAttach((Attachable) returnValue);
        return returnValue;
    }

    private void executeAttach(Attachable attachable) {
        final Set<AttachmentType> types = AttachmentTypeHolder.getTypes();
        final Map<AttachmentType, Attachment> attachmentMap = types.stream()
                .flatMap(type -> typeToServiceMap.get(type).stream())
                .filter(service -> service.getSupportType().isAssignableFrom(attachable.getClass()))
                .collect(Collectors.toMap(AttachService::getSupportAttachmentType, service -> service.getAttachment(attachable)));

        attachable.attach(attachmentMap);
    }
}
