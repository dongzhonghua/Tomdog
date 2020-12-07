package xyz.dsvshx.myTomcat.proxy.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import xyz.dsvshx.myTomcat.proxy.BookFacade;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
public class ProxyTest {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream ips = new FileInputStream(
                new File("/Users/dzh/Documents/kuai/github/Tomdog/myTomcat/src/main/resources/proxy.properties"));
        Object xxx = new BeanFactory(ips).getBean("xxx");
        BookFacade bean = (BookFacade) new BeanFactory(ips).getBean("xxx");
        bean.addBook();
        System.out.println(bean.getClass().getName());
    }
}
