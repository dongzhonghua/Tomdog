package xyz.dsvshx.myTomcat.proxy.aop;

import java.lang.reflect.Method;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
public class AdviceImpl implements Advice {
    private long beginTime;
    private long endTime;

    @Override
    public void beforeAdvice(Method method) {
        System.out.println("----进入切面----");
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterAdvice(Method method) {
        endTime = System.currentTimeMillis();
        System.out.println("方法用时共计：" + (endTime - beginTime));
    }

}
