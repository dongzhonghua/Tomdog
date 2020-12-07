package xyz.dsvshx.aop;

import java.lang.reflect.Method;

import xyz.dsvshx.aop.annotation.Aspect;
import xyz.dsvshx.aop.annotation.LogAspect;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Aspect(LogAspect.class)
public class TestAspect extends AspectProxy {
    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        super.before(cls, method, params);
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        super.after(cls, method, params, result);
    }
}
