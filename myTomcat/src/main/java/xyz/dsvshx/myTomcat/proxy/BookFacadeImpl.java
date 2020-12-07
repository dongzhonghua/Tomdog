package xyz.dsvshx.myTomcat.proxy;

import java.io.Serializable;

/**
 * @author dongzhonghua
 * Created on 2020-12-06
 */
public class BookFacadeImpl implements BookFacade, Serializable {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }
}
