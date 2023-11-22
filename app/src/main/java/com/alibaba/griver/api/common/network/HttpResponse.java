package com.alibaba.griver.api.common.network;

import android.text.TextUtils;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpResponse implements Serializable {
    public static final int HTTP_OK = 200;
    private long contentLength;
    private Map<String, List<String>> headers;
    private InputStream inputStream;
    private int statusCode;
    private String reasonPhrase = "OK";
    private String protocol = PROTOCOL.HTTP_1_1;

    /* loaded from: classes3.dex */
    public @interface PROTOCOL {
        public static final String HTTP_1_1 = "HTTP/1.1";
        public static final String HTTP_2 = "HTTP/2";
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public void setReasonPhrase(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.reasonPhrase = str;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }
}
