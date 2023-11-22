package com.alibaba.griver.api.common.network;

import java.io.InputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class UploadRequest implements Serializable {
    private byte[] ends;
    private byte[] headers;
    private InputStream inputStream;

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public byte[] getHeaders() {
        return this.headers;
    }

    public void setHeaders(byte[] bArr) {
        this.headers = bArr;
    }

    public byte[] getEnds() {
        return this.ends;
    }

    public void setEnds(byte[] bArr) {
        this.ends = bArr;
    }
}
