package xyz.dsvshx.myTomcat.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
public class ProxyBeanFactoryJDK {

    /**
     * 获得代理类
     *
     * @param target 目标对象
     * @param advice 通知对象
     */
    public static Object getProxy(final Object target, final Advice advice) {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * proxy:调用方法对象
                     * method：调用的方法
                     * args:方法调用时设置参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        advice.beforeAdvice(method);
                        Object retVal = method.invoke(target, args);
                        advice.afterAdvice(method);
                        return retVal;
                    }
                });
        return proxy;
    }

}