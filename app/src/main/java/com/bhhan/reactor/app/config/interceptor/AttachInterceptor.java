package com.bhhan.reactor.app.config.interceptor;

import com.bhhan.reactor.app.attachment.Attach;
import com.bhhan.reactor.app.attachment.AttachmentTypeHolder;
import com.bhhan.reactor.sharedmodel.attachment.AttachmentType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Component
public class AttachInterceptor extends HandlerInterceptorAdapter {
    public static final String TARGET_PARAMETER_NAME = "attachment";
    private static final String TARGET_DELIMITER = ",";
    private final Map<HandlerMethod, Boolean> attachableMap = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        final Boolean isAttachable = attachableMap.computeIfAbsent(handlerMethod, key -> key.hasMethodAnnotation(Attach.class));
        if(!isAttachable){
            return true;
        }

        Set<AttachmentType> types = resolveAttachmentType(request);
        AttachmentTypeHolder.setTypes(types);
        return true;
    }

    private Set<AttachmentType> resolveAttachmentType(HttpServletRequest request) {
        String attachments = request.getParameter(TARGET_PARAMETER_NAME);
        if(StringUtils.isBlank(attachments)){
            return Collections.emptySet();
        }

        return Stream.of(attachments.split(TARGET_DELIMITER))
                .map(AttachmentType::fromCaseIgnoredName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
}
