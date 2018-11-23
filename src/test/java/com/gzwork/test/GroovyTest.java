package com.gzwork.test;

import com.gzwork.groovy.GroovyBeanFactory;
import com.gzwork.groovy.GroovyServ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class GroovyTest {

    private static final GroovyTest groovyTest = new GroovyTest();

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        GroovyBeanFactory groovyBeanFactory = applicationContext.getBean(GroovyBeanFactory.class);
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("请输入标识(y：继续/n：退出)");
            input = scanner.next();
            if ("n".equals(input.toLowerCase(Locale.ENGLISH))) {
                scanner.close();
                break;
            }
            GroovyServ groovyServ = groovyBeanFactory.getJavaObject(groovyTest.getScript());
            System.out.println(groovyServ.say("Gzwork"));
        }
    }

    private String getScript() {
        try {
            File file = ResourceUtils.getFile("H:/idea/gzwork/spring/src/main/java/com/gzwork/groovy/impl/GroovyServImpl.groovy");
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
