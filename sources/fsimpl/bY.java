package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class bY extends fn {
    public final bV a(bV bVVar, int i) {
        int c = c(14);
        if (c != 0) {
            return bVVar.b(d(g(c) + (i * 4)), this.b);
        }
        return null;
    }

    public final bY a() {
        return a(new bY());
    }

    public final bY a(bY bYVar) {
        int c = c(4);
        if (c != 0) {
            return bYVar.b(d(c + this.f7991a), this.b);
        }
        return null;
    }

    public final String a(int i) {
        int c = c(12);
        if (c != 0) {
            return e(g(c) + (i * 4));
        }
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public final byte b() {
        int c = c(6);
        if (c != 0) {
            return this.b.get(c + this.f7991a);
        }
        return (byte) 0;
    }

    public final bV b(int i) {
        return a(new bV(), i);
    }

    public final bY b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public final String c() {
        int c = c(8);
        if (c != 0) {
            return e(c + this.f7991a);
        }
        return null;
    }

    public final String d() {
        int c = c(10);
        if (c != 0) {
            return e(c + this.f7991a);
        }
        return null;
    }

    public final int e() {
        int c = c(12);
        if (c != 0) {
            return f(c);
        }
        return 0;
    }

    public final int f() {
        int c = c(14);
        if (c != 0) {
            return f(c);
        }
        return 0;
    }
}
