package com.alipay.imobile.network.quake.transport.http;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class HttpResponseBody {

    /* renamed from: a  reason: collision with root package name */
    private String f7069a;
    private InputStream b;
    private String c;
    private long d;

    public HttpResponseBody(String str, long j, String str2, InputStream inputStream) {
        this.f7069a = str;
        this.d = j;
        this.c = str2;
        this.b = inputStream;
    }

    public InputStream byteStream() {
        return this.b;
    }

    public void consumeContent() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
            this.b = null;
        }
    }

    public String contentEncoding() {
        return this.c;
    }

    public long contentLength() {
        return this.d;
    }

    public String contentType() {
        return this.f7069a;
    }
}
