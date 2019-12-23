package com.demo;

import com.demo.filter.HelloFilter;
import com.demo.servlet.HelloServlet;

import javax.servlet.*;
import java.io.DataInputStream;
import java.util.EnumSet;
import java.util.Set;
import java.util.jar.JarEntry;

/**
 * @Author: Dely
 * @Date: 2019/12/10 15:21
 */

/**
 * 通过Java提供的实现类的方式来进行对servlet、Filter、listener的注册。
 * 也可以通过在servlet等上边使用servlet3.1之后提供的取代web.xml配置的方式的注解@WebServlet等来进行注册Servlet。
 * 故而有三种方式来配置servlet应用：
 * 1.基于web.xml方式。
 * 2.基于注解方式。
 * 3.基于ServletContainerInitializer接口，并且使用spi技术来实现。
 */
public class CustomServletContainerInitializer  implements ServletContainerInitializer {
    private static final String JAR_HOME_URL = "/hello";

    /**
     *
     * @param set
     * @param servletContext  servlet上下文：维护了整个web容器中注册的servlet，Filter，listener。
     * @throws ServletException
     */
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        //启动容器
        System.out.println("创建hello  servlet ......");

        /**
         * 将servlet添加进servlet容器
         */
        ServletRegistration.Dynamic servlet = servletContext.addServlet(HelloServlet.class.getSimpleName(), HelloServlet.class);
        servlet.addMapping(JAR_HOME_URL); //配置servlet的映射信息。

        FilterRegistration filter = servletContext.addFilter(HelloFilter.class.getSimpleName(), HelloFilter.class);
        System.out.println("创建 hello Filter ....");
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);

        filter.addMappingForUrlPatterns(dispatcherTypes,true, JAR_HOME_URL);
    }
}
