package com.palani.springmongo.log;

import brave.Tracer;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class LogUtil {
	
	 @Autowired
	    private Tracer tracer;

	    public void logError(Logger log, String className, ActionEnum action,
	                          String customMessage, Throwable throwable) {
	        log.error(LogData.builder()
	                        .requestId(tracer.currentSpan().context().traceIdString())
	                        .userId(CommonLogConstants.DEFAULT_USER)
	                        .service(className)
	                        .action(action.name())
	                        //.entityType(type.name())
	                        //.dependentSystem("Manhatten")
	                        .customizedErrorMessage(customMessage)
	                        .success(false)
	                        .build().toString(),
	                throwable
	        );
	    }

	    public void logInfo(Logger log, ActionEnum actionEnum,
	                        String customMessage ) {
	        String[] customFieldsArray = {customMessage};
	        ImmutableList<String> customFields = ImmutableList.copyOf(customFieldsArray);
	        log.info(LogData.builder()
	                .requestId(tracer.currentSpan().context().traceIdString())
	                .action(actionEnum.name())
	                //.dependentSystem("Manhatten")
	               // .entityType(type.name())
	                .customFields(customFields)
	                .build().toString());
	    }
	

}
