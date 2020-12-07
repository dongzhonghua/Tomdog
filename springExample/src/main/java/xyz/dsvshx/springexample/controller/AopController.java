package xyz.dsvshx.springexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.dsvshx.springexample.service.AopTestService;

/**
 * @author dongzhonghua
 * Created on 2020-12-07
 */
@RestController
public class AopController {
    @Autowired
    private AopTestService aopTestServiceImpl;
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/boot/getAop")
    public String aopGet() {
        aopTestServiceImpl.getStudentInfo();
        return "success";
    }

    @RequestMapping("/boot/updateAop")
    public String aopUpdate() {
        // aopTestServiceImpl.update();
        AopTestService aopTestService = (AopTestService) applicationContext.getBean("aopTestServiceImpl");
        aopTestService.update();

        return "success";
    }
}
