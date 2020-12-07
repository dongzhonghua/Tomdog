package xyz.dsvshx.myTomcat.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author dongzhonghua
 * Created on 2020-12-06
 */
public class BookFacadeProxyCglib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        // enhancer.setCallbackType(this.getClass());
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object res = proxy.invokeSuper(obj, args);
        after();
        return res;
    }

    public void before() {
        System.out.println("before run!");

    }

    public void after() {
        System.out.println("after run!");
    }

}
