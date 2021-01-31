package xyz.dsvshx.myTomcat.servlet;

import java.io.IOException;

import xyz.dsvshx.myTomcat.MyRequest;
import xyz.dsvshx.myTomcat.MyResponse;
import xyz.dsvshx.myTomcat.annotation.RequestMapping;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-14
 */
@RequestMapping("Girl")
public class FindGirlServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
