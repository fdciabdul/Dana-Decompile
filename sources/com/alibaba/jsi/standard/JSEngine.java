package com.alibaba.jsi.standard;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import java.lang.annotation.Annotation;

/* loaded from: classes6.dex */
public class JSEngine extends JSEngineBase {
    /* JADX INFO: Access modifiers changed from: protected */
    public JSEngine(Object obj, String str, String str2, String str3, int i, long j, Object obj2) {
        super(obj, str, str2, str3, i, j, obj2);
    }

    public static boolean loadSo(Context context, Bundle bundle) {
        if (context != null) {
            if (bundle == null) {
                throw new NullPointerException("args can not be null");
            }
            Util.initialize(context);
            String string = bundle.getString("jsiSoPath");
            if (string == null) {
                string = bundle.getString("p8SoPath");
            }
            return loadSoImpl(string, bundle.getString("jsEngineSoPath"), bundle.getString("engineType"));
        }
        throw new NullPointerException("context can not be null");
    }

    public static JSEngine createInstance(Context context, Bundle bundle) {
        return createInstance(context, bundle, null);
    }

    public static JSEngine createInstance(Context context, Bundle bundle, Handler handler) {
        if (context == null || bundle == null) {
            throw new NullPointerException("context and args can not be null!");
        }
        String string = bundle.getString("name");
        if (string == null) {
            throw new RuntimeException("'name' not set!");
        }
        String string2 = bundle.getString("version", "");
        String string3 = bundle.getString("flags", "");
        String string4 = bundle.getString("datadir", null);
        if (string4 == null || string4.trim().length() == 0) {
            string4 = "shared";
        }
        String str = string4;
        if (str.startsWith("/")) {
            throw new IllegalArgumentException("'datadir' can not be a absolute path!");
        }
        return createInstanceImpl(context, string, string2, string3, str, bundle.getInt("engine", 0), 0L, handler);
    }

    public JSContext createContext(String str, Bundle bundle) {
        return createContextImpl(str, bundle, null);
    }

    public JSContext createContext(String str, Bundle bundle, Class<? extends Annotation> cls) {
        return createContextImpl(str, bundle, cls);
    }
}
