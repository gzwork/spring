package com.gzwork.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * Json相关辅助
 *
 * @author Gzwork
 * @version v1.0 2018年8月1日 11:39:24
 */
public final class JsonUtils {

    private JsonUtils() {

    }

    /**
     * 对象转json串
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * json转对象
     *
     * @param json  json
     * @param clazz class
     * @param <T>   对象类型
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 转换列表类型的对象
     *
     * @param json  json
     * @param clazz class
     * @param <T>   泛型类型
     * @return List<T>
     */
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }
}
