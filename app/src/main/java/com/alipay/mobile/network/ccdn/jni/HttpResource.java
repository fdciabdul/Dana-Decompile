package com.alipay.mobile.network.ccdn.jni;

import com.alipay.mobile.network.ccdn.storage.HttpCacheController;
import java.util.Map;

/* loaded from: classes6.dex */
public class HttpResource {
    private byte[] content;
    private String etag;
    private boolean expired;
    private byte[] header;
    private Map<String, String> headers;
    private String lastModified;
    private long maxAge;
    private int origin;
    private long timestamp;
    private String url;

    public HttpResource(String str) {
        this.url = str;
    }

    private void init(byte[] bArr, byte[] bArr2, String str, String str2, long j, long j2, boolean z, int i) {
        this.header = bArr;
        this.content = bArr2;
        this.etag = str;
        this.lastModified = str2;
        this.timestamp = j;
        this.maxAge = j2;
        this.expired = z;
        this.origin = i;
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] getHeader() {
        return this.header;
    }

    public byte[] getContent() {
        return this.content;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Map<String, String> getHttpHeaders() {
        if (this.headers == null) {
            try {
                byte[] bArr = this.header;
                this.headers = HttpCacheController.deserializeHttpHeader(bArr, 0, bArr.length);
            } catch (Throwable unused) {
            }
        }
        return this.headers;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public String getEtag() {
        return this.etag;
    }

    public long getMaxAge() {
        return this.maxAge;
    }

    public int getOrigin() {
        return this.origin;
    }

    public boolean isExpired() {
        return this.expired;
    }
}
