package xyz.dzh.myTomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-13
 */
public class MyResponse {
    private final OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        // HTTP/1.1 200 OK
        // Date: Sat, 31 Dec 2005 23:59:59 GMT
        // Content-Type: text/html;charset=ISO-8859-1
        // Content-Length: 122
        //
        // ＜html＞ ＜/html＞
        String httpResponse = "HTTP/1.1 200 OK\n"
                + "Content-Type: text/html\n"
                + "\r\n"
                + "<html><body>"
                + content
                + "</body></html>";
        outputStream.write(httpResponse.getBytes());
        outputStream.close();
    }
}
