package com.pykj.v1.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PYRequestParam {
    String value() default "";
}
