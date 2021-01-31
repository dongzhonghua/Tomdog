package xyz.dsvshx.util;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua
 * Created on 2020-12-13
 */
@Slf4j
class ClassUtilTest {
    @org.junit.jupiter.api.Test
    void getClassListByPackage() {
        List<Class<?>> classListByPackage = ClassUtil.getClassListByPackage("xyz.dsvshx");
        log.info(classListByPackage.toString());
    }

    @org.junit.jupiter.api.Test
    void getClassListByAnnotation() {
    }

    @org.junit.jupiter.api.Test
    void getClassListBySuper() {
    }
}