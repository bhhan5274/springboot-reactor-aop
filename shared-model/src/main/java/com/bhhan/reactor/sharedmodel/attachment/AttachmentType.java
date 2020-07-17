package com.bhhan.reactor.sharedmodel.attachment;

import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Getter
public enum AttachmentType {
    COMMENT, WRITER;

    private static Map<String, AttachmentType> nameToTypeMap;

    public String lowerCaseName(){
        return this.name().toLowerCase();
    }

    public static AttachmentType fromCaseIgnoredName(String name){
        if(nameToTypeMap == null){
            initMap();
        }

        return nameToTypeMap.get(name.toUpperCase());
    }

    private static void initMap(){
        final Map<String, AttachmentType> temp = Stream.of(AttachmentType.values())
                .collect(Collectors.toMap(type -> type.name().toUpperCase(), Function.identity()));
        AttachmentType.nameToTypeMap = Collections.unmodifiableMap(temp);
    }
}
