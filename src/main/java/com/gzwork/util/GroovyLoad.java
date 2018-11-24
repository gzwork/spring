package com.gzwork.util;


import groovy.lang.GroovyClassLoader;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;

public final class GroovyLoad {


    private static final Map<String, Object> DICT = new HashMap<>();

    private GroovyLoad() {

    }


    /**
     * 从脚本加载一个对象
     *
     * @param script 脚本文件
     * @param <T>    泛型
     * @return 对象
     */
    public static <T> T getObjectByScript(String script) {
        String key = DigestUtils.md5Hex(script);
        Object object = DICT.get(key);
        if (null == object) {
            GroovyClassLoader classLoader = new GroovyClassLoader();
            Class clazz = classLoader.parseClass(script);
            try {
                Object o = clazz.newInstance();
                DICT.put(key, o);
                return (T) o;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (T) object;
    }

}
