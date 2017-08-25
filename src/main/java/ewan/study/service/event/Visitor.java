package ewan.study.service.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by ewan on 25/08/2017.
 */

@Component
public class Visitor implements ApplicationContextAware {
    ApplicationContext applicationContext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Visitor() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void knockAtDoor() {
        this.applicationContext.publishEvent(new KnockAtDoorEvent(this));
    }

    public String answerName() {
        return name;
    }
}