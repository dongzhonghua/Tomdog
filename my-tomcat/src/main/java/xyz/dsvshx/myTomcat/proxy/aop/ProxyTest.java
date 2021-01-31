package xyz.dsvshx.myTomcat.proxy.aop;

import java.io.FileNotFoundException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Slf4j
public class ProxyTest {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream ips = ProxyTest.class.getClassLoader().getResourceAsStream("proxy.properties");
        BeanFactory beanFactory = new BeanFactory(ips);
        Object xxx = beanFactory.getBean("xxx");
        Greeting bean = (Greeting) beanFactory.getBean("xxx");
        bean.sayHello();
        log.info(bean.getClass().getName());
    }
}
