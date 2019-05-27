package com.task.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Interface proxy
 *
 * @author Kong Lingming
 * @date May 27, 2019
 */

public class HandlerUtil {

    private Object target;

    private HandlerUtil(Object target) {
        this.target = target;
    }

    @SuppressWarnings({ "unchecked" })
    public static <E> E createProxy(Class<E> Interface, Class<?> clazz) {
        E target = null;
        E proxy = null;
        try {
            target = (E) clazz.newInstance();
            proxy = (E) new HandlerUtil(target).getProxyInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxy;
    }

    private Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = method.invoke(target, args);
                return returnValue;
            }
        });
    }

}