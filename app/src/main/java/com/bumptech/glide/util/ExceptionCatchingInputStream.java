package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

@Deprecated
/* loaded from: classes7.dex */
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> PlaceComponentResult = Util.BuiltInFictitiousFunctionClassFactory(0);
    private InputStream BuiltInFictitiousFunctionClassFactory;
    private IOException KClassImpl$Data$declaredNonStaticMembers$2;

    ExceptionCatchingInputStream() {
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.BuiltInFictitiousFunctionClassFactory.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.BuiltInFictitiousFunctionClassFactory.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.BuiltInFictitiousFunctionClassFactory.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.BuiltInFictitiousFunctionClassFactory.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.BuiltInFictitiousFunctionClassFactory.read(bArr);
        } catch (IOException e) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.BuiltInFictitiousFunctionClassFactory.read(bArr, i, i2);
        } catch (IOException e) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            this.BuiltInFictitiousFunctionClassFactory.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.BuiltInFictitiousFunctionClassFactory.skip(j);
        } catch (IOException e) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.BuiltInFictitiousFunctionClassFactory.read();
        } catch (IOException e) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
            return -1;
        }
    }
}
