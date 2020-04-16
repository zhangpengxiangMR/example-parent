package com.pykj.annotation.demo.annotation.configure.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/15 12:06
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.pykj.annotation.project.entity.MyMember",
                            "com.pykj.annotation.project.entity.MyCompany"};
    }
}
