package ewan.study.service.observe.jdkObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ewan on 26/08/2017.
 */
public class MouseJimmy implements Observer {
    public void run(){
        System.out.println("Jimmy ran into the hole");
    }

    @Override
    public void update(Observable o, Object arg) {
        run();
    }
}