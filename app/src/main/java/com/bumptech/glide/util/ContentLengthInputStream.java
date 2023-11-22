package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private int BuiltInFictitiousFunctionClassFactory;
    private final long MyBillsEntityDataFactory;

    public static InputStream getAuthRequestContext(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    private ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.MyBillsEntityDataFactory = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        int max;
        synchronized (this) {
            max = (int) Math.max(this.MyBillsEntityDataFactory - this.BuiltInFictitiousFunctionClassFactory, this.in.available());
        }
        return max;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read;
        synchronized (this) {
            read = super.read();
            MyBillsEntityDataFactory(read >= 0 ? 1 : -1);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int MyBillsEntityDataFactory;
        synchronized (this) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(super.read(bArr, i, i2));
        }
        return MyBillsEntityDataFactory;
    }

    private int MyBillsEntityDataFactory(int i) throws IOException {
        if (i >= 0) {
            this.BuiltInFictitiousFunctionClassFactory += i;
        } else if (this.MyBillsEntityDataFactory - this.BuiltInFictitiousFunctionClassFactory > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to read all expected data, expected: ");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", but read: ");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            throw new IOException(sb.toString());
        }
        return i;
    }
}
