package xyz.dzh.myTomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-14
 */
public class ServletMappingConfig {
    private static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "xyz.dzh.myTomcat.servlet.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWord", "/world", "xyz.dzh.myTomcat.servlet.HelloWorldServlet"));
    }

    public static List<ServletMapping> getServletMappingList() {
        return servletMappingList;
    }
}
