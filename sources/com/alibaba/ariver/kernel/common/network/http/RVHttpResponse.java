package com.alibaba.ariver.kernel.common.network.http;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class RVHttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private int f6149a;
    private Map<String, List<String>> b;
    private InputStream c;

    public int getStatusCode() {
        return this.f6149a;
    }

    public void setStatusCode(int i) {
        this.f6149a = i;
    }

    public Map<String, List<String>> getHeaders() {
        return this.b;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.b = map;
    }

    public InputStream getResStream() {
        return this.c;
    }

    public void setResStream(InputStream inputStream) {
        this.c = inputStream;
    }
}
