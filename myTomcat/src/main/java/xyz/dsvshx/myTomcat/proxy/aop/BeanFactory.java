package xyz.dsvshx.myTomcat.proxy.aop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import xyz.dsvshx.myTomcat.proxy.BookFacade;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
public class BeanFactory {
    private Properties properties = new Properties();

    public BeanFactory(InputStream ips) {//初始化加载配置文件
        try {
            properties.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("资源加载完成.");
    }

    public Object getBean(String name) {
        Object bean = null;
        try {
            //实例化类
            bean = Class.forName(properties.getProperty(name)).newInstance();
            System.out.println(bean.getClass().getInterfaces()[0]);
            String targetClass = properties.getProperty(name + ".target");
            Object target = Class.forName(targetClass).newInstance();
            Advice advice = (Advice) Class.forName(properties.getProperty(name + ".advice")).newInstance();
            bean = ProxyBeanFactory.getProxy(target, advice);
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
            System.out.println("---" + bean.getClass());
            String targetClass = properties.getProperty(name + ".target");
            Object target = Class.forName(targetClass).newInstance();
            Advice advice = (Advice) Class.forName(properties.getProperty(name + ".advice")).newInstance();
            bean = ProxyBeanFactory.getProxy(target, advice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) bean;
    }

    public static void main(String[] args) throws FileNotFoundException {
        BookFacade asdf = new BeanFactory(new FileInputStream("")).getBeanInterface("asdf");
    }

}