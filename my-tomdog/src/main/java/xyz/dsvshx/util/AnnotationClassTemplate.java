package xyz.dsvshx.util;

import java.lang.annotation.Annotation;

/**
 * @author dongzhonghua
 * Created on 2021-01-31
 */
public abstract class AnnotationClassTemplate extends ClassTemplate {

    protected final Class<? extends Annotation> annotationClass;

    protected AnnotationClassTemplate(String packageName, Class<? extends Annotation> annotationClass) {
        super(packageName);
        this.annotationClass = annotationClass;
    }
}
