package com.alibaba.ariver.kernel.common.io;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayPool f6125a;

    public PoolingByteArrayOutputStream() {
        this(IOUtils.getByteArrayPool(), 1024);
    }

    public PoolingByteArrayOutputStream(int i) {
        this(IOUtils.getByteArrayPool(), i);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 1024);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i) {
        this.f6125a = byteArrayPool;
        this.buf = byteArrayPool.getBuf(Math.max(i, 1024));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6125a.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f6125a.returnBuf(this.buf);
    }

    private void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] buf = this.f6125a.getBuf((this.count + i) * 2);
        System.arraycopy(this.buf, 0, buf, 0, this.count);
        this.f6125a.returnBuf(this.buf);
        this.buf = buf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        synchronized (this) {
            a(i2);
            super.write(bArr, i, i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(int i) {
        synchronized (this) {
            a(1);
            super.write(i);
        }
    }
}
