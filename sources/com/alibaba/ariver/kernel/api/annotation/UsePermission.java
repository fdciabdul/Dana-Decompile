package com.alibaba.ariver.kernel.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface UsePermission {
    String desc() default "";

    String value() default "";
}
