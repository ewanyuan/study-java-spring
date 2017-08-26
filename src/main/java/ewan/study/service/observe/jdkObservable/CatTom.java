package ewan.study.service.observe.jdkObservable;

import java.util.Observable;

/**
 * Created by ewan on 26/08/2017.
 */
//被观察者
public class CatTom extends Observable{
    public void shout(){
        System.out.println("Tom shouted");
        //必须要加setChanged，否则Observers不会做出响应
        setChanged();
        notifyObservers();
    }
}