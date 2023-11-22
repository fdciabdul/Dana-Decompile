package com.iap.ac.android.common.rpc.model;

import com.iap.ac.android.common.json.JsonUtils;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpRequest implements Serializable {
    public static final int DEFAULT_TIMEOUT_MS = 30000;
    public static final int TYPE_SERVER_AC = 1;
    public static final int TYPE_SERVER_PSP = 0;
    public static final int TYPE_SERVER_REGION = 2;
    public String data;
    public Map<String, String> headers;
    public HttpMethod method;
    public boolean notFollowRedirects;
    public int timeoutMilliseconds;
    public String url;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ForwardType {
    }

    public HttpRequest(String str, HttpMethod httpMethod, String str2) {
        this(str, httpMethod, null, str2);
    }

    public HttpRequest addHeader(String str, Object obj) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        if (obj == null) {
            this.headers.put(str, null);
        } else {
            this.headers.put(str, String.valueOf(obj));
        }
        return this;
    }

    public String toString() {
        return JsonUtils.toJson(this);
    }

    public HttpRequest(String str, HttpMethod httpMethod, Map<String, String> map, String str2) {
        this(str, httpMethod, map, str2, 30000);
    }

    public HttpRequest(String str, HttpMethod httpMethod, Map<String, String> map, String str2, int i) {
        this.url = str;
        this.method = httpMethod;
        this.headers = map;
        this.data = str2;
        this.timeoutMilliseconds = i;
    }
}
