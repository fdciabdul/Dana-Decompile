package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes3.dex */
public final class ExceptionPassthroughInputStream extends InputStream {
    public static final Queue<ExceptionPassthroughInputStream> BuiltInFictitiousFunctionClassFactory = Util.BuiltInFictitiousFunctionClassFactory(0);
    public InputStream KClassImpl$Data$declaredNonStaticMembers$2;
    public IOException MyBillsEntityDataFactory;

    public static ExceptionPassthroughInputStream getAuthRequestContext(InputStream inputStream) {
        ExceptionPassthroughInputStream poll;
        Queue<ExceptionPassthroughInputStream> queue = BuiltInFictitiousFunctionClassFactory;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionPassthroughInputStream();
        }
        poll.KClassImpl$Data$declaredNonStaticMembers$2 = inputStream;
        return poll;
    }

    ExceptionPassthroughInputStream() {
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.KClassImpl$Data$declaredNonStaticMembers$2.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.read();
        } catch (IOException e) {
            this.MyBillsEntityDataFactory = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.read(bArr);
        } catch (IOException e) {
            this.MyBillsEntityDataFactory = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.read(bArr, i, i2);
        } catch (IOException e) {
            this.MyBillsEntityDataFactory = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        synchronized (this) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.reset();
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        try {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.skip(j);
        } catch (IOException e) {
            this.MyBillsEntityDataFactory = e;
            throw e;
        }
    }
}
