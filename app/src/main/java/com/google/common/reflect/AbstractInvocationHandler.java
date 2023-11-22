package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    @CheckForNull
    protected abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    @Override // java.lang.reflect.InvocationHandler
    @CheckForNull
    public final Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
        if (objArr == null) {
            objArr = NO_ARGS;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        if (objArr.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object obj2 = objArr[0];
            if (obj2 == null) {
                return Boolean.FALSE;
            }
            if (obj == obj2) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(isProxyOfSameInterfaces(obj2, obj.getClass()) && equals(Proxy.getInvocationHandler(obj2)));
        } else if (objArr.length == 0 && method.getName().equals("toString")) {
            return toString();
        } else {
            return handleInvocation(obj, method, objArr);
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    private static boolean isProxyOfSameInterfaces(Object obj, Class<?> cls) {
        return cls.isInstance(obj) || (Proxy.isProxyClass(obj.getClass()) && Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces()));
    }
}
