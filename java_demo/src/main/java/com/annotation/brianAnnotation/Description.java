package com.annotation.brianAnnotation;

import java.lang.annotation.*;

/**
 * Created by Brian in 17:44 2018/3/9
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();

    String author();

    int age() default 18;
}
