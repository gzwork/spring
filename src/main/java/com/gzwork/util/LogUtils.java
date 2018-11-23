package com.gzwork.util;

import org.apache.logging.log4j.Logger;

/**
 * 日志相关辅助
 *
 * @author Gzwork
 * @version v1.0 2018年8月1日 11:39:24
 */
public final class LogUtils {

    private LogUtils() {

    }

    /**
     * 打印debug日志
     *
     * @param logger 记录器
     * @param format 格式化字符串
     * @param params 参数
     */
    public static void debug(Logger logger, String format, Object... params) {
        if (logger.isDebugEnabled()) {
            logger.info(String.format(format, params));
        }
    }

    /**
     * 打印info日志
     *
     * @param logger 记录器
     * @param format 格式化字符串
     * @param params 参数
     */
    public static void info(Logger logger, String format, Object... params) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format(format, params));
        }
    }

    /**
     * 打印warn日志
     *
     * @param logger    记录器
     * @param throwable 异常信息
     * @param format    格式化字符串
     * @param params    参数
     */
    public static void warn(Logger logger, Throwable throwable, String format, Object... params) {
        if (logger.isWarnEnabled()) {
            logger.warn(String.format(format, params), throwable);
        }
    }

    /**
     * 打印error日志
     *
     * @param logger    记录器
     * @param throwable 异常信息
     * @param format    格式化字符串
     * @param params    参数
     */
    public static void error(Logger logger, Throwable throwable, String format, Object... params) {
        if (logger.isErrorEnabled()) {
            logger.error(String.format(format, params), throwable);
        }
    }
}
