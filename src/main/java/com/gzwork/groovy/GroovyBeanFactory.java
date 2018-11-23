package com.gzwork.groovy;

public interface GroovyBeanFactory {
    /**
     * 获取一个java对象
     *
     * @param script groovy脚本
     * @param <T>    泛型
     * @return Java对象
     */
    <T> T getJavaObject(String script);
}
