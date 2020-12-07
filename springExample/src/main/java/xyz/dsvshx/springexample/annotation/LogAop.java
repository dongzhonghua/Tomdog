package xyz.dsvshx.springexample.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Retention(RetentionPolicy.CLASS)
public @interface LogAop {

    /**
     * 使用@annotation、@within、@target、@args匹配注解
     * //匹配标注有LogAop注解的方法
     * @Pointcut("@annotation(com.example.demo.annotation.LogAop)")
     * public void matchAnno() {}
     *
     * //匹配标注有LogAop的类底下的方法，要求annotation的Retention级别为CLASS
     * @Pointcut("@within(com.example.demo.annotation.LogAop)")
     * public void matchWithin() {}
     *
     * //匹配标注有LogAop的类底下的方法，要求annotation的Retention级别为RUNTIME
     * @Pointcut("@target(com.example.demo.annotation.LogAop)")
     * public void matchTarget() {}
     *
     * //匹配传入的参数类标注有LogAop注解的方法
     * @Pointcut("@args(com.example.demo.annotation.LogAop)")
     * public void matchArgs() {}
     */
}
