package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private int PlaceComponentResult;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.PlaceComponentResult = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            super.mark(i);
            this.PlaceComponentResult = i;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (MyBillsEntityDataFactory(1L) == -1) {
            return -1;
        }
        int read = super.read();
        int i = this.PlaceComponentResult;
        if (i != Integer.MIN_VALUE) {
            this.PlaceComponentResult = (int) (i - 1);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int MyBillsEntityDataFactory = (int) MyBillsEntityDataFactory(i2);
        if (MyBillsEntityDataFactory == -1) {
            return -1;
        }
        int read = super.read(bArr, i, MyBillsEntityDataFactory);
        long j = read;
        int i3 = this.PlaceComponentResult;
        if (i3 != Integer.MIN_VALUE && j != -1) {
            this.PlaceComponentResult = (int) (i3 - j);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            super.reset();
            this.PlaceComponentResult = Integer.MIN_VALUE;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long MyBillsEntityDataFactory = MyBillsEntityDataFactory(j);
        if (MyBillsEntityDataFactory == -1) {
            return 0L;
        }
        long skip = super.skip(MyBillsEntityDataFactory);
        int i = this.PlaceComponentResult;
        if (i != Integer.MIN_VALUE && skip != -1) {
            this.PlaceComponentResult = (int) (i - skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    private long MyBillsEntityDataFactory(long j) {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE) {
            long j2 = i;
            return j > j2 ? j2 : j;
        }
        return j;
    }
}
