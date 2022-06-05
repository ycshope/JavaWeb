package com.kali.aop.jdkproxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxyMain {
    @Test
    public void jdkProxyMain() {
        // 动态代理
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        /*
         * arg1:类加载器
         * arg2:增强方法所在的类,这个类实现的接口(支持多个接口)
         * arg3:实现这个接口InvocationHandler,创建代理对象,写增强的部分
         * */
        UserDao dao = (UserDao) Proxy.newProxyInstance(JdkProxyMain.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        System.out.println("result=" + dao.add(1, 2));
    }
}

/*
 * 创建代理对象
 * */
class UserDaoProxy implements InvocationHandler {
    private Object object;

    //1. 创建的是谁的对象,就要把谁传递过来
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    /*
     * 增强的逻辑
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        System.out.println("method running before" + method.getName() + ":convert args" + Arrays.toString(args));

        // 被增加的方法执行
        Object invoke = method.invoke(object, args);

        // 方法之后
        System.out.println("after method running " + object);
        return invoke;
    }
}