package com.gzwork.groovy;

import com.gzwork.util.GroovyLoad;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @author Gzwork
 * @version v1.0.0 2018/11/24 13:41
 */
public class GroovyBeanLoad implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
    /**
     * 记录日志
     */
    private static final Logger LOGGER = LogManager.getLogger(GroovyBeanLoad.class);
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (null == event.getApplicationContext().getParent()) {
            register();
        }
    }

    /**
     * 定时任务，每天晚上1点删除数据表t_tempClob中的所有记录
     */
    @Scheduled(cron = "0/10 * * * * ? ")
    private void refreshGroovyBean() {
        register();
        GroovyBeanReloadEvent groovyBeanReloadEvent = new GroovyBeanReloadEvent(context);
        context.publishEvent(groovyBeanReloadEvent);
        LOGGER.info("刷新GroovyBean");
    }

    /**
     * 注册Groovy对象到spring容器
     */
    private void register() {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        GenericBeanDefinition definition = new GenericBeanDefinition();
        Object object = GroovyLoad.getObjectByScript(getScript());
        definition.setBeanClass(object.getClass());
        factory.registerBeanDefinition("groovyServ", definition);
    }

    /**
     * 获取脚本内容
     *
     * @return 脚本
     */
    private String getScript() {
        try {
            File file = ResourceUtils.getFile("classpath:groovy/GroovyServImpl.groovy");
            Reader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            while (null != (s = reader.readLine())) {
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
