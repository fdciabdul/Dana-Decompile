package com.alibaba.ariver.legacy.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;

/* loaded from: classes6.dex */
public class JSConsole {
    public static String concat(V8Array v8Array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v8Array.length(); i++) {
            Object obj = v8Array.get(i);
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(obj);
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
        }
        return sb.toString();
    }

    public static void setup(V8 v8) {
        v8.registerJavaMethod(new JavaVoidCallback() { // from class: com.alibaba.ariver.legacy.v8worker.JSConsole.1
            @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                RVLogger.d("V8WorkerConsole", JSConsole.concat(v8Array));
            }
        }, "__nativeLog__");
    }
}
