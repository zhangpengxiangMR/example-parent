package com.pykj.annotation.demo.annotation.configure.componentscan;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/14 22:06
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * @param metadataReader        获取当前正在操作类的信息
     * @param metadataReaderFactory 获取上下文中类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获得当前类的所有的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获得当前扫描到的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获得当前类的所有的资源
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("----" + className + "----");
        if (className.contains("er")) {
            return true;
        }
        return false;
    }
}
