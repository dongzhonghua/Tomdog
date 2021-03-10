package xyz.dsvshx.springexample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dsvshx.springexample.annotation.LogAop;

/**
 * @author dongzhonghua
 * Created on 2021-03-10
 */
@Service
public class ServiceB {
    @Autowired
    private ServiceA serviceA;

    @LogAop
    public void a() {
        System.out.println(">>>>>>>>>>>>> service a");
    }
}
