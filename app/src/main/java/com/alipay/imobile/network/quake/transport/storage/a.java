package com.alipay.imobile.network.quake.transport.storage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class a extends BufferedInputStream {

    /* renamed from: a  reason: collision with root package name */
    protected int f7073a;

    public a(InputStream inputStream) {
        super(inputStream, 8192);
        this.f7073a = 0;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        synchronized (this) {
            read = super.read(bArr, i, i2);
            if (read > 0) {
                this.f7073a += read;
            }
        }
        return read;
    }
}
