package ewan.study.service.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ewan on 25/08/2017.
 * java动态代理
 */

@Configuration
public class DynamicProxyDemo {

    //这种方式要求被代理类(UserDaoImpl)必须要实现接口（UserDao)
    @Bean(name="userDaoProxyByJdk")
    public UserDao GetUserDaoProxyByJdk(){
        final UserDao userDao = new UserDaoImpl();
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object realObj, Method method, Object[] args) throws Throwable {
                        System.out.println("preparing...");
                        Object result = method.invoke(userDao, args);
                        System.out.println("end.");
                        return result;
                    }
                });

        return userDaoProxy;
    }

    //spring aop就是通过cglib实现的
    @Bean
    public MethodInterceptor GetUserDaoProxyByCglib(){
        MethodInterceptor userDaoProxy = new MethodInterceptor() {
            private Object target;
            @Bean(name="userDaoProxyByCglib")
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
                System.out.println("preparing...");
                methodProxy.invokeSuper(o, args);
                System.out.println("end.");
                return null;
            }
        };

        return userDaoProxy;
    }


    public interface UserDao{
        void add();
    }

    public class UserDaoImpl implements UserDao{
        public void add() {
            System.out.println("data Added");
        }
    }
}
