package com.gzwork.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author Gzwork
 * @version v1.0.0 2018/11/24 14:36
 */
public class GroovyBeanReloadEvent extends ApplicationContextEvent {

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public GroovyBeanReloadEvent(ApplicationContext source) {
        super(source);
    }
}
