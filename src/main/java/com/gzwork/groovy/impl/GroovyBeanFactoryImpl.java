package com.gzwork.groovy.impl;

import com.gzwork.groovy.GroovyBeanFactory;
import com.gzwork.util.GroovyLoad;
import org.springframework.stereotype.Component;

@Component
public class GroovyBeanFactoryImpl implements GroovyBeanFactory {

    @Override
    public <T> T getJavaObject(String script) {
        return GroovyLoad.getObjectByScript(script);
    }
}
