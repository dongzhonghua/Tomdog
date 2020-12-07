package xyz.dsvshx.myTomcat;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dongzhonghua <dongzhonghua03@kuaishou.com>
 * Created on 2020-05-14
 */
@Data
@AllArgsConstructor
public class ServletMapping {
    private String servletName;
    private String url;
    private String clazz;
}
