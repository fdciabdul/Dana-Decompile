package com.iap.ac.android.common.rpc.http;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class HttpTransportFactory {
    public static Creater creater;
    public static ConcurrentHashMap<String, Creater> createrMap = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public interface Creater {
        AbstractHttpTransport createHttpTransport(Context context) throws Exception;
    }

    public static AbstractHttpTransport createHttpTransport(Context context) throws Exception {
        Creater creater2 = creater;
        if (creater2 != null) {
            return creater2.createHttpTransport(context);
        }
        throw new IOException("Cannot find creater for HttpTransportFactory!");
    }

    public static Creater getCreater() {
        return creater;
    }

    public static void setCreater(Creater creater2) {
        creater = creater2;
    }

    public static Creater getCreater(String str) {
        return createrMap.get(str);
    }

    public static void setCreater(Creater creater2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        createrMap.put(str, creater2);
    }

    public static AbstractHttpTransport createHttpTransport(Context context, String str) throws Exception {
        Creater creater2 = getCreater(str);
        if (creater2 == null) {
            creater2 = creater;
        }
        if (creater2 != null) {
            return creater2.createHttpTransport(context);
        }
        throw new IOException("Cannot find creater for HttpTransportFactory!");
    }
}
