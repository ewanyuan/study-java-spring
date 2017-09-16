package ewan.study.service.placeHolder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by ewan on 16/09/2017.
 */

@Component
public class PostProcessor implements BeanPostProcessor {
    private Pattern pattern = Pattern.compile("ToLog.*");

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (isMatch(o.getClass().getSimpleName()))
        {
            return proxyBean(o);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }

    private boolean isMatch(String className) {
        return pattern.matcher(className).matches();
    }

    private Object proxyBean(Object target) {
        return new LoggingProxy().getInstance(target);
    }

    private class LoggingProxy implements MethodInterceptor{

        private Object target;

        public Object getInstance(Object target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            //设置enhancer的超类为被代理类
            enhancer.setSuperclass(this.target.getClass());
            //设置enhancer的回调为拦截类
            enhancer.setCallback(this);
            // 创建代理对象
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("准备执行"+o.getClass().getSimpleName()+"的方法:"+method.getName());
            methodProxy.invokeSuper(o, args);
            System.out.println("执行方法结束:"+o.getClass().getSimpleName()+"的方法:"+method.getName());
            return null;
        }
    }
}
