package ewan.study.service.observe.simple;

import java.util.List;

/**
 * Created by ewan on 26/08/2017.
 */
public class simpleObserveMain {
    public static void main(String[] args) {
        CatTom catTom = new CatTom();

        //注册观察者到被观察者
        List<Mouse> mouseList = catTom.getMouses();
        mouseList.add(new MouseJimmy());
        mouseList.add(new MouseJerry());
        catTom.setMouses(mouseList);

        catTom.shout();
    }
}
