package com.alibaba.ariver.ariverexthub.api.annotations;

import com.alibaba.ariver.ariverexthub.api.model.RVEExecutorType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface RVEThreadType {
    RVEExecutorType value();
}
