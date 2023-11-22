package com.alibaba.griver.base.nebula;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes6.dex */
public class DynamicProxy {
    public static <T> T dynamicProxy(Class<T> cls, final Object obj) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.alibaba.griver.base.nebula.DynamicProxy.1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                try {
                    return obj.getClass().getMethod(method.getName(), method.getParameterTypes()).invoke(obj, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
        });
    }
}
