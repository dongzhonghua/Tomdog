package xyz.dsvshx.myTomcat.proxy.aop;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-06
 */
@Slf4j
public class GreetingImpl implements Greeting, Serializable {
    @Override
    public void sayHello() {
        log.info("say hello。。。");
    }
}
