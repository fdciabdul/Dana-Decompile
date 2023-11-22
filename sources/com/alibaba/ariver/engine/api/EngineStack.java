package com.alibaba.ariver.engine.api;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes3.dex */
public class EngineStack {

    /* renamed from: a  reason: collision with root package name */
    private static String f6016a = "AriverEngine:EngineStack";
    private static EngineStack b;
    private Map<String, Stack<WeakReference<RVEngine>>> c = new HashMap();

    private EngineStack() {
    }

    public static EngineStack getInstance() {
        if (b == null) {
            b = new EngineStack();
        }
        return b;
    }

    private Stack<WeakReference<RVEngine>> a(String str) {
        Stack<WeakReference<RVEngine>> stack;
        synchronized (this) {
            stack = this.c.get(str);
            if (stack == null) {
                stack = new Stack<>();
                this.c.put(str, stack);
            }
        }
        return stack;
    }

    public void pushEnginePorxy(RVEngine rVEngine) {
        if (rVEngine == null) {
            RVLogger.d(f6016a, "push  empty engineProxy");
            return;
        }
        String str = f6016a;
        StringBuilder sb = new StringBuilder();
        sb.append("push proxy appId=");
        sb.append(rVEngine.getAppId());
        sb.append(" ,appinstanceid =");
        sb.append(rVEngine.getInstanceId());
        sb.append(" , obj=");
        sb.append(rVEngine.hashCode());
        sb.append(" targetType=");
        sb.append(rVEngine.getClass());
        RVLogger.d(str, sb.toString());
        synchronized (this) {
            a(rVEngine.getEngineType()).push(new WeakReference<>(rVEngine));
        }
    }

    public void removeProxy(RVEngine rVEngine) {
        if (rVEngine == null) {
            RVLogger.d(f6016a, "reomve  empty engineProxy");
            return;
        }
        String str = f6016a;
        StringBuilder sb = new StringBuilder();
        sb.append("remove proxy appId=");
        sb.append(rVEngine.getAppId());
        sb.append(" , obj=");
        sb.append(rVEngine.hashCode());
        sb.append(" targetType=");
        sb.append(rVEngine.getClass());
        RVLogger.d(str, sb.toString());
        synchronized (this) {
            Stack<WeakReference<RVEngine>> a2 = a(rVEngine.getEngineType());
            if (a2.isEmpty()) {
                return;
            }
            WeakReference<RVEngine> weakReference = null;
            Iterator<WeakReference<RVEngine>> it = a2.iterator();
            while (it.hasNext()) {
                WeakReference<RVEngine> next = it.next();
                if (next != null && next.get() == rVEngine) {
                    weakReference = next;
                }
            }
            if (weakReference != null) {
                a2.remove(weakReference);
            }
        }
    }

    public RVEngine getByInstanceId(String str, String str2) {
        synchronized (this) {
            Stack<WeakReference<RVEngine>> a2 = a(str);
            if (a2.isEmpty()) {
                return null;
            }
            Iterator<WeakReference<RVEngine>> it = a2.iterator();
            while (it.hasNext()) {
                WeakReference<RVEngine> next = it.next();
                if (next != null && next.get() != null && TextUtils.equals(next.get().getInstanceId(), str2)) {
                    return next.get();
                }
            }
            return null;
        }
    }

    public RVEngine getTopProxy(String str) {
        synchronized (this) {
            Stack<WeakReference<RVEngine>> a2 = a(str);
            while (!a2.isEmpty()) {
                WeakReference<RVEngine> peek = a2.peek();
                if (peek != null && peek.get() != null) {
                    return peek.get();
                }
                a2.pop();
            }
            return null;
        }
    }
}
