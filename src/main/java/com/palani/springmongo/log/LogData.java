package com.palani.springmongo.log;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogData {
    private String requestId;
    private String userId;
    private String service;
    private String action;
    private String entityType;
    private String entityId;
    private String dependentSystem;
    private Boolean success;
    private String customizedErrorMessage;
    private ImmutableList<String> customFields;

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("requestId: ", requestId);
        map.put("userId: ", userId);
        map.put("service: ", service);
        map.put("action: ", action);
        map.put("entityType: ", entityType);
        map.put("entityId: ", entityId);
        map.put("dependentSystem: ", dependentSystem);
        map.put("success: ", success == null ? null : success.toString());
        map.put("customizedErrorMessage: ", customizedErrorMessage);

        map.entrySet().iterator().forEachRemaining(a -> {
            if(a.getValue() != null) {
                strBuilder.append(a.getKey()).append(a.getValue()).append(", ");
            }
        });

        if(customFields != null) {
            customFields.stream().forEachOrdered(cf -> strBuilder.append(cf).append(", "));
        }

        strBuilder.replace(strBuilder.lastIndexOf(","), strBuilder.length()-1, "");

        return strBuilder.toString();
    }
}
