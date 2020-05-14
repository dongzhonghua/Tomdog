package xyz.dzh.myTomcat;

import java.io.IOException;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-14
 */
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
