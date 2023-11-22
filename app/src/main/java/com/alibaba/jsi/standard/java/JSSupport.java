package com.alibaba.jsi.standard.java;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.jsi.standard.Events;
import com.alibaba.jsi.standard.J2JHelper;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.JSEngine;
import com.alibaba.jsi.standard.OSUtil;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSException;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public class JSSupport {
    private final JSContext mContext;
    private final J2JHelper mJ2JHelper;
    private final Map<JSInvocationHandler, Object> mJSIProxys = new WeakHashMap();

    public JSSupport(JSContext jSContext, J2JHelper j2JHelper) {
        this.mContext = jSContext;
        this.mJ2JHelper = j2JHelper;
    }

    public void reset() {
        Iterator<JSInvocationHandler> it = this.mJSIProxys.keySet().iterator();
        while (it.hasNext()) {
            it.next().detach();
        }
        this.mJSIProxys.clear();
    }

    public <T> T get(String str, Class<T> cls) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        JSObject jSObject = null;
        try {
            jSObject = this.mContext.globalObject();
            return (T) getImpl(this.mContext, jSObject, str, cls);
        } finally {
            if (jSObject != null) {
                jSObject.delete();
            }
            engineScope.exit();
        }
    }

    public <T> T get(JSObject jSObject, String str, Class<T> cls) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return (T) getImpl(this.mContext, jSObject, str, cls);
        } finally {
            engineScope.exit();
        }
    }

    public <T> T as(JSObject jSObject, Class<T> cls) {
        return (T) asImpl(this.mContext, jSObject, cls.getName(), cls);
    }

    public boolean remove(Object obj) {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        if (invocationHandler instanceof JSInvocationHandler) {
            EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
            try {
                ((JSInvocationHandler) invocationHandler).detach();
                this.mJSIProxys.remove(invocationHandler);
                engineScope.exit();
                return true;
            } catch (Throwable th) {
                engineScope.exit();
                throw th;
            }
        }
        return false;
    }

    private <T> T getImpl(JSContext jSContext, JSObject jSObject, String str, Class<T> cls) {
        JSValue jSValue = jSObject.get(jSContext, str);
        if (jSValue == null) {
            return null;
        }
        if (!(jSValue instanceof JSObject)) {
            jSValue.delete();
            return null;
        }
        return (T) asImpl(jSContext, (JSObject) jSValue, str, cls);
    }

    private <T> T asImpl(JSContext jSContext, JSObject jSObject, String str, Class<T> cls) {
        Throwable th;
        JSInvocationHandler jSInvocationHandler;
        T t = null;
        try {
            jSInvocationHandler = new JSInvocationHandler(jSContext, jSObject, str);
            try {
                T t2 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, jSInvocationHandler);
                try {
                    this.mJSIProxys.put(jSInvocationHandler, null);
                    if (t2 == null) {
                        jSInvocationHandler.detach();
                    }
                    return t2;
                } catch (Throwable th2) {
                    th = th2;
                    t = t2;
                    if (t == null) {
                        if (jSInvocationHandler != null) {
                            jSInvocationHandler.detach();
                            throw th;
                        }
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            jSInvocationHandler = null;
        }
    }

    /* loaded from: classes6.dex */
    public class JSInvocationHandler implements InvocationHandler {
        private JSContext mContext;
        private String mName;
        private JSObject mObject;

        JSInvocationHandler(JSContext jSContext, JSObject jSObject, String str) {
            JSSupport.this = r1;
            this.mContext = jSContext;
            this.mObject = jSObject;
            this.mName = str;
        }

        public void detach() {
            JSObject jSObject = this.mObject;
            if (jSObject != null) {
                jSObject.delete();
                this.mObject = null;
            }
        }

        protected void finalize() throws Throwable {
            super.finalize();
            if (this.mObject != null) {
                JSSupport.this.mJ2JHelper.markUnused(this.mObject);
                this.mObject = null;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            try {
                JSEngine jSEngine = this.mContext.getJSEngine();
                if (jSEngine.isDisposed()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("JSEngine \"");
                    sb.append(jSEngine.getEmbedderName());
                    sb.append("\" has been disposed");
                    throw new RuntimeException(sb.toString());
                } else if (this.mContext.isDisposed()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("JSContext {");
                    sb2.append(this.mContext.getTitle());
                    sb2.append(", id ");
                    sb2.append(this.mContext.getId());
                    sb2.append("} has been disposed");
                    throw new RuntimeException(sb2.toString());
                } else if (this.mObject == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("JSIProxy \"");
                    sb3.append(this.mName);
                    sb3.append("\" has been detached");
                    throw new RuntimeException(sb3.toString());
                } else {
                    return invokeImpl(method, objArr);
                }
            } catch (Throwable th) {
                Events eventListener = this.mContext.getEventListener();
                if (eventListener == null || !eventListener.onJSSupportException(this.mContext, th)) {
                    throw th;
                }
                Class<?> returnType = method.getReturnType();
                if (returnType == Void.TYPE || !returnType.isPrimitive()) {
                    return null;
                }
                if (returnType == Boolean.TYPE) {
                    return Boolean.FALSE;
                }
                if (returnType == Integer.TYPE || returnType == Long.TYPE) {
                    return 0;
                }
                if (returnType == Float.TYPE || returnType == Double.TYPE) {
                    return 0;
                }
                if (returnType == Short.TYPE) {
                    return (short) 0;
                }
                if (returnType == Character.TYPE) {
                    return (char) 0;
                }
                return returnType == Byte.TYPE ? (byte) 0 : null;
            }
        }

        private Object invokeImpl(Method method, Object[] objArr) {
            EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
            try {
                JSValue jSValue = this.mObject.get(this.mContext, method.getName());
                if (jSValue == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("No JS method named \"");
                    sb.append(method.getName());
                    sb.append("\" in \"");
                    sb.append(this.mName);
                    sb.append("\"");
                    throw new RuntimeException(sb.toString());
                } else if (jSValue instanceof JSFunction) {
                    JSException exception = this.mContext.getException();
                    if (exception != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Clear previous pending JS exception: ");
                        sb2.append(exception.getMessage(this.mContext));
                        OSUtil.e(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("JS stack: ");
                        sb3.append(exception.getStack(this.mContext));
                        OSUtil.e(sb3.toString());
                        exception.delete();
                    }
                    JSFunction jSFunction = (JSFunction) jSValue;
                    JSValue[] jSValueArr = null;
                    if (objArr != null) {
                        jSValueArr = new JSValue[objArr.length];
                        int length = objArr.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            jSValueArr[i2] = JSSupport.this.mJ2JHelper.javaToJS(this.mContext, objArr[i]);
                            i++;
                            i2++;
                        }
                    }
                    JSValue call = jSFunction.call(this.mContext, this.mObject, jSValueArr);
                    jSValue.delete();
                    if (jSValueArr != null) {
                        for (JSValue jSValue2 : jSValueArr) {
                            if (jSValue2 != null) {
                                jSValue2.delete();
                            }
                        }
                    }
                    if (!this.mContext.hasException()) {
                        Object jsToJava = JSSupport.this.mJ2JHelper.jsToJava(this.mContext, call);
                        if (call != null) {
                            call.delete();
                        }
                        return jsToJava;
                    }
                    if (call != null) {
                        call.delete();
                    }
                    JSContext jSContext = this.mContext;
                    throw new JSRuntimeException(jSContext, jSContext.getException());
                } else {
                    jSValue.delete();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("\"");
                    sb4.append(method.getName());
                    sb4.append("\" in \"");
                    sb4.append(this.mName);
                    sb4.append("\" is not a function");
                    throw new RuntimeException(sb4.toString());
                }
            } finally {
                engineScope.exit();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("JSIProxy@");
            sb.append(this.mName);
            sb.append(AUScreenAdaptTool.PREFIX_ID);
            sb.append(Integer.toHexString(hashCode()));
            return sb.toString();
        }
    }
}
