package com.gzwork.test;

import com.gzwork.groovy.GroovyBeanReloadEvent;
import com.gzwork.groovy.GroovyServ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
public class GroovyTest implements ApplicationListener<GroovyBeanReloadEvent> {

    private GroovyServ groovyServ;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        GroovyServ groovyServ;
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("请输入标识(y：继续/n：退出)");
            groovyServ = applicationContext.getBean(GroovyServ.class);
            input = scanner.next();
            if ("n".equals(input.toLowerCase(Locale.ENGLISH))) {
                scanner.close();
                break;
            }
            System.out.println(groovyServ.say("Gzwork"));
        }
    }

    @Override
    public void onApplicationEvent(GroovyBeanReloadEvent event) {
        ApplicationContext context = (ApplicationContext) event.getSource();
        groovyServ = context.getBean(GroovyServ.class);
        System.out.println("做点什么");
    }
}
