package xyz.dsvshx.myTomcat.proxy.aop;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */

import java.lang.reflect.Method;

/**
 * 模拟通知
 *
 * @author Administrator
 */
public interface Advice {
    /**
     * 前置通知
     */
    public void beforeAdvice(Method method);

    /**
     * 后置通知
     */
    public void afterAdvice(Method method);

}
