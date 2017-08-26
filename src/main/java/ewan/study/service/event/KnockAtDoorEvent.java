package ewan.study.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by ewan on 25/08/2017.
 */

//事件
public class KnockAtDoorEvent extends ApplicationEvent {
    private Visitor vistor;

    public KnockAtDoorEvent(Object source) {
        super(source);
        vistor = (Visitor) source;
    }

    public String answerName(){
        return vistor.answerName();
    }
}
