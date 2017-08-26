package ewan.study.service.observe.jdkObservable;
/**
 * Created by ewan on 26/08/2017.
 */
public class JDKObserveMain {
    public static void main(String[] args) {
        CatTom catTom = new CatTom();

        //注册观察者到被观察者
        catTom.addObserver(new MouseJimmy());
        catTom.addObserver(new MouseJerry());

        catTom.shout();
    }
}
