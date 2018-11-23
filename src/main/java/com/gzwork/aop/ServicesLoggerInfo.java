package com.gzwork.aop;

import com.gzwork.util.JsonUtils;
import com.gzwork.util.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;


/**
 * services日志记录
 *
 * @author Gzwork
 * @version v1.0 2018年8月1日 11:39:24
 */
public class ServicesLoggerInfo {

    /**
     * 日志记录器
     */
    private final static Logger LOGGER = LogManager.getLogger(ServicesLoggerInfo.class);

    /**
     * 方法开始调用时，记录其日志
     */
    public void bengin(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        String params = JsonUtils.toJsonString(joinPoint.getArgs());
        LogUtils.info(LOGGER, "ClassName:%s\tMethodName:%s\tParams:%s", className, method, params);
    }
}
