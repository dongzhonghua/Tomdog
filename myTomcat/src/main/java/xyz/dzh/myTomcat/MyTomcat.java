package xyz.dzh.myTomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import xyz.dzh.myTomcat.servlet.MyServlet;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-14
 */
@Slf4j
public class MyTomcat {
    private int port = 8080;
    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start() {
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            log.info("mytomcat is start...");
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                // 把请求封装成我们自己的request
                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                // 请求分发
                dispatch(myRequest, myResponse);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        String clazz = urlServletMap.get(myRequest.getUrl());
        try {
            Class<MyServlet> myservletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myservletClass.newInstance();
            myServlet.service(myRequest, myResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initServletMapping() {
        // for (ServletMapping servletMapping : ServletMappingConfig.getServletMappingList()) {
        //     urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        // }
        urlServletMap = ServletMappingConfig.getAllServlet();
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(String[] args) {

        new MyTomcat(8080).start();
    }
}
