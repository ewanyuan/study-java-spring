package ewan.study.service.observe.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewan on 26/08/2017.
 */
//被观察者
public class CatTom{
    public List<Mouse> getMouses() {
        return mouses;
    }

    public void setMouses(List<Mouse> mouses) {
        this.mouses = mouses;
    }

    private List<Mouse> mouses = new ArrayList<Mouse>();

    public void shout(){
        System.out.println("Tom shouted");
        for(Mouse mouse : mouses)
            mouse.run();
    }
}