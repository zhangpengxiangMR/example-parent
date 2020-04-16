package com.pykj.v2.spring.framework.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PYAutowired {
    String value() default "";
}
