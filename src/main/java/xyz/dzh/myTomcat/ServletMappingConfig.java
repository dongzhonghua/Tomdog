package xyz.dzh.myTomcat;

import static xyz.dzh.myTomcat.utils.ClassUtils.getClassName;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.s;
import org.junit.jupiter.api.Test;

import xyz.dzh.myTomcat.annotation.RequestMapping;
import xyz.dzh.myTomcat.utils.ClassUtils;

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

    public static Map<String, String> getAllServlet() {
        Map<String, String> map = new HashMap<>();
        String packageName = "xyz.dzh.myTomcat.servlet";
        Set<String> classNames = getClassName(packageName, true);
        for (String className : classNames) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
            if (annotation != null) {
                map.put("/" + annotation.value(), className);
            }
        }
        return map;

    }

    public static void main(String[] args) throws Exception {
        Map<String, String> allServlet = getAllServlet();
    }
}
