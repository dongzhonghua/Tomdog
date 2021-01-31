package xyz.dsvshx.myTomcat.proxy.aop;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author dongzhonghua
 * Created on 2020-12-06
 */
@Slf4j
public class ProxyBeanFactoryCglib {

    public static Object getProxy(Object target, final Advice advice) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        // 回调方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                advice.beforeAdvice(method);
                Object res = methodProxy.invokeSuper(o, args);
                advice.afterAdvice(method);
                return res;
            }
        });
        // 创建代理对象
        return enhancer.create();
    }
}
