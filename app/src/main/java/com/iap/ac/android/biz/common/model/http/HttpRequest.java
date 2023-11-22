package com.iap.ac.android.biz.common.model.http;

import com.iap.ac.android.common.json.JsonUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class HttpRequest implements Serializable {
    public static final int DEFAULT_TIMEOUT_MS = 30000;
    public boolean cache;
    public String data;
    public Map<String, String> headers;
    public HttpMethod method;
    public boolean notFollowRedirects;
    public int timeoutMilliseconds;
    public String url;

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

    public HttpRequest setCache(boolean z) {
        this.cache = z;
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
