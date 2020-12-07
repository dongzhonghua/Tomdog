package xyz.dsvshx.springexample.SpringAOP;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Slf4j
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("before");
    }
}
