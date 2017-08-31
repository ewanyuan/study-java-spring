package ewan.study.service.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by ewan on 25/08/2017.
 */

//消息发布者

//写法一，用ApplicationContext发事件
//@Component
//public class Visitor implements ApplicationContextAware {
//    ApplicationContext applicationContext;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    String name;
//
//    public Visitor() {
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        //通过ApplicationContextAware拿到applicationContext
//        this.applicationContext = applicationContext;
//    }
//
//    public void knockAtDoor() {
//        this.applicationContext.publishEvent(new KnockAtDoorEvent(this));
//    }
//
//    public String answerName() {
//        return name;
//    }
//}

//写法二： 用ApplicationEventPublisher发事件
@Component
public class Visitor {
    private final ApplicationEventPublisher publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @Autowired
    public Visitor(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void knockAtDoor() {
        this.publisher.publishEvent(new KnockAtDoorEvent(this));
    }

    public String answerName() {
        return name;
    }
}
