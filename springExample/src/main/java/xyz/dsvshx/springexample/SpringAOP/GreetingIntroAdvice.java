package xyz.dsvshx.springexample.SpringAOP;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Component
@Slf4j
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Wave {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    @Override
    public void hello() {
        log.info("helloooooooooooooooooo");
    }
}
