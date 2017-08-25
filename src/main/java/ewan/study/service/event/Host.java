package ewan.study.service.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;

/**
 * Created by ewan on 25/08/2017.
 */

//注意：Listener为内部类的情况下，内部类和外部类都要加@Component等被容器管理，否则不能监听到事件。

@Component
public class Host {
    private boolean OpenTheDoor(String guestName) {
        if (guestName.equalsIgnoreCase("ZHANGSAN")) {
            System.out.println("door opened");
            return  true;
        }
        return false;
    }

//    @Component
//    public class EarsOfHost implements ApplicationListener {
//        @Override
//        public void onApplicationEvent(ApplicationEvent event) {
//            if (!(event instanceof ApplicationEvent)) //不要用这种写法
//                return;
//
//            String guestName = ((KnockAtDoorEvent)event).answerName();
//            OpenTheDoor(guestName);
//        }
//    }

    @Component
    public class EarsOfHost implements ApplicationListener<KnockAtDoorEvent> {
        @Override
        public void onApplicationEvent(KnockAtDoorEvent knockAtDoorEvent) {
            String guestName = knockAtDoorEvent.answerName();
            OpenTheDoor(guestName);
        }
    }


    /*@Component
    public class EarsOfHost {
        //spring4.1 以上写法
        //将继承去掉用注解的方法，大大增加了灵活性
        @EventListener
        public void onApplicationEvent(KnockAtDoorEvent knockAtDoorEvent) {
            String guestName = knockAtDoorEvent.answerName();
            OpenTheDoor(guestName);
        }
    }*/
}
