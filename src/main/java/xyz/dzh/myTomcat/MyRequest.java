package xyz.dzh.myTomcat;

import java.io.IOException;
import java.io.InputStream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-13
 */
@Data
@Slf4j
public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";

        byte[] httpRequestBytes = new byte[1024];
        int length = inputStream.read(httpRequestBytes);
        if (length > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
            log.info(httpRequest);
        }
        //GET /search?hl=zh-CN&source=hp&q=domety&aq=f&oq= HTTP/1.1
        // Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg
        // Accept-Language: zh-cn
        // Accept-Encoding: gzip, deflate
        // User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; TheWorld)
        // Host: www.google.cn
        // Connection: Keep-Alive
        // Cookie: PREF=ID=80a06da87be9ae3c:U=f7167333e2c3b714:NW=1:TM=1261551909:LM=1261551917:S=ybYcq2wpfefs4V9g;
        String httpHeader = httpRequest.split("\n")[0];
        method = httpHeader.split("\\s")[0];
        url = httpHeader.split("\\s")[1];
        System.out.println(this);
    }
    public String getMethod() {
        return this.method;
    }
}
