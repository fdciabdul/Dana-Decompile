package com.alibaba.ariver.engine.api.bridge.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface BindingCallback {
    boolean isSticky() default false;
}
