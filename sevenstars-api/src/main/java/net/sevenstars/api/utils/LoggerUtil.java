package net.sevenstars.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    protected Logger LOGGER;
    protected boolean isDebug;
    protected String messagePrefix;

    public LoggerUtil(String prefix, boolean debug){
        messagePrefix = prefix;
        LOGGER = LoggerFactory.getLogger(prefix);
        isDebug = debug;
    }

    public void logDebugMsg(String msg) {
        if(isDebug){
            LOGGER.info(buildMessage(msg));
        }
    }

    private String buildMessage(String msg) {
        return "[%s] - %s".formatted(messagePrefix, msg);
    }

    public void logInfoMsg(String msg) {
        LOGGER.info(buildMessage(msg));
    }

    public void logError(String msg) {
        LOGGER.error(buildMessage(msg));
    }

    public void logError(String msg, Exception e) {
        LOGGER.error(buildMessage(msg), e);
    }

    public void logTrace(String msg) {
        LOGGER.trace(buildMessage(msg));
    }

    public void logWarn(String msg) {
        LOGGER.warn(buildMessage(msg));
    }
}
