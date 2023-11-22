package com.iap.ac.config.lite.a;

import java.nio.ByteBuffer;
import kotlin.UShort;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f7617a;
    private int b = -1;
    private int c = -1;

    public b(byte[] bArr) {
        this.f7617a = ByteBuffer.wrap(bArr);
    }

    private void d(int i) throws a {
        if (i > g()) {
            throw new a("end of input");
        }
    }

    public void a() {
        ByteBuffer byteBuffer = this.f7617a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public int b() {
        return this.f7617a.position();
    }

    public void c(int i) {
        if (i <= this.f7617a.capacity() - this.f7617a.position()) {
            ByteBuffer byteBuffer = this.f7617a;
            byteBuffer.limit(byteBuffer.position() + i);
            return;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
    }

    public long e() throws a {
        d(4);
        return this.f7617a.getInt() & 4294967295L;
    }

    public int f() throws a {
        d(1);
        return this.f7617a.get() & 255;
    }

    public int g() {
        return this.f7617a.remaining();
    }

    public void h() {
        int i = this.b;
        if (i >= 0) {
            this.f7617a.position(i);
            this.f7617a.limit(this.c);
            this.b = -1;
            this.c = -1;
            return;
        }
        throw new IllegalStateException("no previous state");
    }

    public void i() {
        this.b = this.f7617a.position();
        this.c = this.f7617a.limit();
    }

    public void a(int i) {
        if (i < this.f7617a.capacity()) {
            this.f7617a.position(i);
            ByteBuffer byteBuffer = this.f7617a;
            byteBuffer.limit(byteBuffer.capacity());
            return;
        }
        throw new IllegalArgumentException("cannot jump past end of input");
    }

    public byte[] b(int i) throws a {
        d(i);
        byte[] bArr = new byte[i];
        this.f7617a.get(bArr, 0, i);
        return bArr;
    }

    public int d() throws a {
        d(2);
        return this.f7617a.getShort() & UShort.MAX_VALUE;
    }

    public byte[] c() throws a {
        return b(f());
    }

    public void a(byte[] bArr, int i, int i2) throws a {
        d(i2);
        this.f7617a.get(bArr, i, i2);
    }
}
