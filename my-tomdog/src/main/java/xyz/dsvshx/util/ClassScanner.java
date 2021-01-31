package xyz.dsvshx.util;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author dongzhonghua
 * Created on 2021-01-31
 */
public interface ClassScanner {
    // 实现一个功能，先抽象出一个接口，黄勇写得那一系列博客就有这种风格，最前面的一定是定义一个接口。
    /**
     * 获取指定包名中的所有类
     */
    List<Class<?>> getClassList(String packageName);

    /**
     * 获取指定包名中指定注解的相关类
     */
    List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass);

    /**
     * 获取指定包名中指定父类或接口的相关类
     */
    List<Class<?>> getClassListBySuper(String packageName, Class<?> superClass);
}
