package com.iap.ac.android.rpc.http.proxy;

import com.iap.ac.android.common.rpc.model.HttpMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface HttpReqMethod {
    HttpMethod value();
}
