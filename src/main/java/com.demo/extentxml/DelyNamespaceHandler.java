package com.demo.extentxml;

/**
 * @Author: Dely
 * @Date: 2019/12/12 13:19
 */

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 编写 Handler 来帮助 spring 解析 XML中 不同命名空间的各类元素。
 */
public class DelyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        super.registerBeanDefinitionParser("application", new DelyBeanDefinitionParser(ApplicationConfig.class));
        super.registerBeanDefinitionParser("service", new DelyBeanDefinitionParser(ServiceBean.class));
    }
}
