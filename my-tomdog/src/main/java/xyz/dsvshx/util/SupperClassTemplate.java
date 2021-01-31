package xyz.dsvshx.util;

/**
 * @author dongzhonghua
 * Created on 2021-01-31
 */
public abstract class SupperClassTemplate extends ClassTemplate {

    protected final Class<?> superClass;

    protected SupperClassTemplate(String packageName, Class<?> superClass) {
        super(packageName);
        this.superClass = superClass;
    }
}
