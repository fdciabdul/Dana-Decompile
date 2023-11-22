package com.alipay.imobile.network.quake.transport.http;

import com.alipay.imobile.network.quake.transport.http.HttpHeaders;
import java.util.List;

/* loaded from: classes3.dex */
public class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private final int f7067a;
    private final String b;
    private final HttpHeaders c;
    private final HttpResponseBody d;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f7068a;
        private String c;
        private HttpResponseBody e;
        private int b = -1;
        private HttpHeaders.Builder d = new HttpHeaders.Builder();

        public Builder addHeader(String str, String str2) {
            this.d.add(str, str2);
            return this;
        }

        public Builder body(HttpResponseBody httpResponseBody) {
            this.e = httpResponseBody;
            return this;
        }

        public HttpResponse build() {
            if (this.b >= 0) {
                return new HttpResponse(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("code < 0: ");
            sb.append(this.b);
            throw new IllegalStateException(sb.toString());
        }

        public Builder code(int i) {
            this.b = i;
            return this;
        }

        public Builder header(String str, String str2) {
            this.d.set(str, str2);
            return this;
        }

        public Builder headers(HttpHeaders httpHeaders) {
            this.d = httpHeaders.a();
            return this;
        }

        public Builder message(String str) {
            this.c = str;
            return this;
        }

        public Builder protocol(String str) {
            this.f7068a = str;
            return this;
        }

        public Builder removeHeader(String str) {
            this.d.removeAll(str);
            return this;
        }
    }

    public List<String> a(String str) {
        return this.c.a(str);
    }

    public int b() {
        return this.f7067a;
    }

    public HttpHeaders c() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{code=");
        sb.append(this.f7067a);
        sb.append(", message=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }

    private HttpResponse(Builder builder) {
        String unused = builder.f7068a;
        this.f7067a = builder.b;
        this.b = builder.c;
        this.c = builder.d.build();
        this.d = builder.e;
    }

    public HttpResponseBody a() {
        return this.d;
    }
}
