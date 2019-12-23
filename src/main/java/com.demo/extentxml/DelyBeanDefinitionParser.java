package com.demo.extentxml;

/**
 * @Author: Dely
 * @Date: 2019/12/12 13:52
 */


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * 解析器
 */
public class DelyBeanDefinitionParser implements BeanDefinitionParser {
    private final Class<?> beanClass;

    /**
     * @param beanClass
     */
    public DelyBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * 重写接口方法
     *
     * @param element
     * @param parserContext
     * @return
     */
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return parse(element, parserContext, beanClass);
    }

    /**
     * @param element
     * @param parserContext
     * @param beanClass
     * @return
     */
    public static BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass) {
        RootBeanDefinition root = new RootBeanDefinition(beanClass);
        root.setLazyInit(false);

        String name = element.getAttribute("name");
        root.getPropertyValues().addPropertyValue("name", name);
        parserContext.getRegistry().registerBeanDefinition(name, root);
        return root;
    }
}
