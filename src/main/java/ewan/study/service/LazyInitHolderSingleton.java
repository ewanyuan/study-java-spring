package ewan.study.service;

/**
 * Created by ewan on 24/08/2017.
 */
public class LazyInitHolderSingleton {
    //内部类开始
    private static class SingletonHolder{
        //静态初始化器，由JVM来保证线程安全
        private static LazyInitHolderSingleton instance=new LazyInitHolderSingleton();
    }
    //内部类结束

    private LazyInitHolderSingleton(){
    }

    public static LazyInitHolderSingleton getInstance(){
        //保证了在使用时才会去访问SingletonHolder，从而实例化LazyInitHolderSingleton
        return SingletonHolder.instance;
    }
}
