package xyz.dsvshx.springexample.SpringAOP;

import java.util.Arrays;

import org.springframework.aop.framework.ProxyFactory;

import xyz.dsvshx.myTomcat.proxy.BookFacade;
import xyz.dsvshx.myTomcat.proxy.BookFacadeImpl;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new BookFacadeImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        // proxyFactory.addAdvice(new GreetingIntroAdvice());
        System.out.println(Arrays.toString(proxyFactory.getProxy().getClass().getInterfaces()));
        // Wave proxy = (Wave) proxyFactory.getProxy();
        // proxy.hello();
        BookFacade proxy = (BookFacade) proxyFactory.getProxy();
        proxy.addBook();

    }
}
