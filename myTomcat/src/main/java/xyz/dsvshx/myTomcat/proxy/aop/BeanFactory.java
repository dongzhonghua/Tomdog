package xyz.dsvshx.myTomcat.proxy.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Slf4j
public class BeanFactory {
    private Properties properties = new Properties();

    public BeanFactory(InputStream ips) {//初始化加载配置文件
        try {
            properties.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("资源加载完成.");
    }

    public Object getBean(String name) {
        Object bean = null;
        try {
            //实例化类
            bean = Class.forName(properties.getProperty(name)).newInstance();
            log.info(String.valueOf(bean.getClass().getInterfaces()[0]));
            String targetClass = properties.getProperty(name + ".target");
            Object target = Class.forName(targetClass).newInstance();
            Advice advice = (Advice) Class.forName(properties.getProperty(name + ".advice")).newInstance();
            bean = ProxyBeanFactoryCglib.getProxy(target, advice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public <T> T getBeanInterface(String name) {
        Object bean = null;
        try {
            //实例化类
            bean = Class.forName(properties.getProperty(name)).newInstance();
            log.info("---" + bean.getClass());
            String targetClass = properties.getProperty(name + ".target");
            Object target = Class.forName(targetClass).newInstance();
            Advice advice = (Advice) Class.forName(properties.getProperty(name + ".advice")).newInstance();
            bean = ProxyBeanFactoryJDK.getProxy(target, advice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) bean;
    }
}