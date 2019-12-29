package com.annotation;

import com.annotation.brianAnnotation.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Brian in 17:58 2018/3/9
 */
public class ParseAnn {
    public static void main(String[] args) {
        // 1. 使用类加载器加载类
        try {
            Class c = Class.forName("com.annotation.service.impl.Child");

            // 2. 找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                // 3. 拿到注解实例
                Description dscr = (Description) c.getAnnotation(Description.class);
                System.out.println(dscr.desc());

                // 4. 找到方法上的注解
                Method[] ms = c.getMethods();
                for (Method m : ms) {
                    boolean isMExist = m.isAnnotationPresent(Description.class);
                    if (isMExist) {
                        Description dscr2 = m.getAnnotation(Description.class);
                        System.out.println(dscr2.desc());
                    }
                }

                // 另一种解析方式
                for (Method m : ms) {
                    Annotation[] as = m.getAnnotations();
                    for (Annotation a : as) {
                        if (a instanceof Description) {
                            Description desr3 = (Description) a;
                            System.out.println(desr3.desc());
                        }
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
