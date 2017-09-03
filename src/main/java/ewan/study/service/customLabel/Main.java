package ewan.study.service.customLabel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ewan on 03/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("ch5/Beans_origin.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch5/Beans.xml");
        Customer customer1=(Customer) ctx.getBean("customer1");
        Customer customer=(Customer) ctx.getBean("customer");
        System.out.println(customer1.getName());
        System.out.println(customer.getName());
    }
}
