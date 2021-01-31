package xyz.dsvshx.myTomcat.proxy.aop;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Slf4j
public class AdviceImpl implements Advice {
    private long beginTime;
    private long endTime;

    @Override
    public void beforeAdvice(Method method) {
        log.info("-----进入切面");
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterAdvice(Method method) {
        endTime = System.currentTimeMillis();
        log.info("-----方法用时共计：" + (endTime - beginTime));
    }

}
