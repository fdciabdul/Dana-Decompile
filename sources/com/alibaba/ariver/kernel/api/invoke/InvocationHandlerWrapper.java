package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class InvocationHandlerWrapper implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private ExtensionInvoker f6094a;
    private Object b = new Object();
    private String c;

    public InvocationHandlerWrapper(Class cls, ExtensionInvoker extensionInvoker) {
        this.f6094a = extensionInvoker;
        StringBuilder sb = new StringBuilder();
        sb.append("Proxy@");
        sb.append(cls);
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this.b.hashCode());
        this.c = sb.toString();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            if ("toString".equals(method.getName())) {
                return this.c;
            }
            return method.invoke(this.b, objArr);
        }
        return this.f6094a.invoke(obj, method, objArr);
    }
}
