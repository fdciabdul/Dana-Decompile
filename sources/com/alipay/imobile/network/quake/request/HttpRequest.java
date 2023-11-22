package com.alipay.imobile.network.quake.request;

import com.alipay.imobile.network.quake.Request;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class HttpRequest extends Request {
    private final int x;

    /* loaded from: classes6.dex */
    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    public HttpRequest(int i, String str, Type type, Request.Listener listener, Request.ErrorListener errorListener) {
        super(str, type, listener, errorListener);
        this.x = i;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":");
        sb.append(str);
        setCacheKey(sb.toString());
    }

    public int getMethod() {
        return this.x;
    }
}
