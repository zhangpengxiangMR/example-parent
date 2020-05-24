package com.pykj.v2.spring.framework.beans.support;

import com.pykj.v2.spring.framework.beans.config.PYBeanDefinition;
import com.pykj.v2.spring.framework.core.PYBeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/18 15:57
 */
public class PYDefaultListableBeanFactory implements PYBeanFactory {

    /**
     * beanDefinition缓存
     */
    public Map<String, PYBeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public Object getBean(Class beanClass) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * 把Definition保存到beanDefinitionMap
     * @param beanDefiinitions
     * @throws Exception
     */
    public void doRegistBeanDefinition(List<PYBeanDefinition> beanDefiinitions) throws Exception {
        for (PYBeanDefinition beanDefiinition : beanDefiinitions) {
            if(this.beanDefinitionMap.containsKey(beanDefiinition.getFactoryBeanName())) {
                //continue;
                throw new Exception("The" + beanDefiinition.getFactoryBeanName() +"is exists");
            }
            beanDefinitionMap.put(beanDefiinition.getFactoryBeanName(),beanDefiinition);
            beanDefinitionMap.put(beanDefiinition.getBeanClassName(),beanDefiinition);
        }
    }
}
