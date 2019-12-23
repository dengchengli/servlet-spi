package com.demo.extentxml;

/**
 * @Author: Dely
 * @Date: 2019/12/12 12:56
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * spring 支持的对xml文件的扩展：spring为基于xml构建的应用，提供了一种扩展机制，用于定义和配置bean。它允许使用者编写自定义的xml解析器。并将自定义的解析器
 *                               和最终定义的bean集成到spring的IOC容器中。
 *
 *    **实现xml的自定义扩展：
 *         **编写一个XML Schema 的文件，描述你的节点元素:
 *             *demo中定义了application 和 service 两个节点元素。
 *
 *
 *         **编写一个NamespaceHandler的实现类.
 *             *编写一个实现了 NamespaceHandlerSupport类 的实现类。用来将指定Element对象的名字和所对应的Javabean封装成的BeanDefinitionParser的解析类。
 *
 *
 *         **编写一个或者多个的BeanDefinitionParser的实现（关键步骤）：即对element对象解析成rootDefinitionBean对象。
 *             *用来将上一步传入的信息，从Element中取出相应的属性信息封装成RootDefinitionBean对象，并且将该对象注册到spring IOC 容器里边。
 *
 *         **注册上边的 Schema 和 Handler。
 *             *因为配置的schema文件和编写的Handler对象需要注入容器，根据spring的原则，编写spring.Handlers和spring.schemas文件，从而将响应的类和文件加载到spring里边。
 *
 */
public class CustomXmlTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dely.xml");
        ApplicationConfig bean = (ApplicationConfig) context.getBean("kirito-demo-application");
        System.out.println(bean.getName());
    }
}
