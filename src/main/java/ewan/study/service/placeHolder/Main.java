package ewan.study.service.placeHolder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ewan on 10/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("placeHolder/auth.xml");
        System.out.println(context.getBean(Connection.class).getPassword());
    }
}
