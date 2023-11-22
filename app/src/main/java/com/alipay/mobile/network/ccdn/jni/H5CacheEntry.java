package com.alipay.mobile.network.ccdn.jni;

import android.text.TextUtils;
import com.alipay.mobile.network.ccdn.storage.HttpCacheController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5CacheEntry {
    private byte[] content;
    private String etag;
    private boolean expired;
    private byte[] header;
    private Map<String, String> headers;
    private String lastModified;
    private long maxAge;
    private Map<String, String> metrics;
    private int origin;
    private long timestamp;
    private String url;
    private boolean valid = false;

    public H5CacheEntry(String str) {
        this.url = str;
    }

    private void init(byte[] bArr, byte[] bArr2, String str, String str2, long j, long j2, boolean z, int i, String[] strArr) {
        this.header = bArr;
        this.content = bArr2;
        this.etag = str;
        this.lastModified = str2;
        this.timestamp = j;
        this.maxAge = j2;
        this.expired = z;
        this.origin = i;
        this.valid = true;
        this.metrics = normalizeMetrics(strArr);
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

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean z) {
        this.valid = z;
    }

    public Map<String, String> getMetrics() {
        return this.metrics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMetrics(String str, String str2) {
        if (this.metrics == null) {
            this.metrics = new HashMap();
        }
        this.metrics.put(str, str2);
    }

    private static Map<String, String> normalizeMetrics(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length - 1; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }
}
