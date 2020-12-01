package xyz.dzh.myTomcat.servlet;

import java.io.IOException;

import xyz.dzh.myTomcat.MyRequest;
import xyz.dzh.myTomcat.MyResponse;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-14
 */
public class HelloWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get hello...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post hello...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
