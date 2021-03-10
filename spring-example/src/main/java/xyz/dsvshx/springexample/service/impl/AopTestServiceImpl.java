package xyz.dsvshx.springexample.service.impl;

import org.springframework.stereotype.Service;

import xyz.dsvshx.springexample.annotation.LogAop;
import xyz.dsvshx.springexample.service.AopTestService;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@Service
public class AopTestServiceImpl implements AopTestService {
    @LogAop
    @Override
    public void getStudentInfo() {
        System.out.println("调用业务处理中的get()方法...");
    }
    @LogAop
    @Override
    public void update() {
        System.out.println("调用业务处理中的update()方法...");
    }
}
