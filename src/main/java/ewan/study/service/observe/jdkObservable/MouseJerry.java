package ewan.study.service.observe.jdkObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ewan on 26/08/2017.
 */
public class MouseJerry implements Observer {
    private void run(){
        System.out.println("Jerry ran onto the roof");
    }

    @Override
    public void update(Observable o, Object arg) {
        run();
    }
}
