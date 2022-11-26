package com.learning.batch.mysqltomongo.util;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class CommonUtils {
	
	private CommonUtils() {
		throw new IllegalStateException("Constants Utility class");
	}
	
	public static String getRootCauseStackTrace(List<Throwable> throwables) {
        StringBuilder sb = new StringBuilder();
        for (Throwable t : throwables) {
            String[] rootCauseStackTrace = ExceptionUtils.getRootCauseStackTrace(t);
            for (String s : rootCauseStackTrace) {
                sb.append(s).append("\n");
            }
        }
        return sb.toString().trim();
    }

}
