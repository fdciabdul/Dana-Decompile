package com.alipay.plus.android.transport.sdk;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class HttpRequest implements Serializable {
    public String data;
    public Map<String, String> headers;
    public HttpMethod method;
    public boolean notFollowRedirects;
    public int timeoutMilliseconds;
    public String url;

    public HttpRequest(String str, HttpMethod httpMethod, String str2) {
        this(str, httpMethod, null, str2);
    }

    public HttpRequest(String str, HttpMethod httpMethod, Map<String, String> map, String str2) {
        this(str, httpMethod, map, str2, 20000);
    }

    public HttpRequest(String str, HttpMethod httpMethod, Map<String, String> map, String str2, int i) {
        this.url = str;
        this.method = httpMethod;
        this.headers = map;
        this.data = str2;
        this.timeoutMilliseconds = i;
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
        return JSON.toJSONString(this);
    }
}
