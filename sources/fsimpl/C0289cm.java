package fsimpl;

import java.nio.ByteBuffer;

/* renamed from: fsimpl.cm  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0289cm extends fn {
    public final bU a(int i) {
        return a(new bU(), i);
    }

    public final bU a(bU bUVar, int i) {
        int c = c(30);
        if (c != 0) {
            return bUVar.b(d(g(c) + (i * 4)), this.b);
        }
        return null;
    }

    public final C0296ct a(C0296ct c0296ct, int i) {
        int c = c(40);
        if (c != 0) {
            return c0296ct.b(d(g(c) + (i * 4)), this.b);
        }
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public final boolean a() {
        int c = c(4);
        return (c == 0 || this.b.get(c + this.f7991a) == 0) ? false : true;
    }

    public final int b() {
        int c = c(6);
        if (c != 0) {
            return this.b.getInt(c + this.f7991a);
        }
        return 0;
    }

    public final C0289cm b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public final C0296ct b(int i) {
        return a(new C0296ct(), i);
    }

    public final int c() {
        int c = c(8);
        if (c != 0) {
            return this.b.getInt(c + this.f7991a);
        }
        return 0;
    }

    public final int d() {
        int c = c(12);
        if (c != 0) {
            return this.b.getInt(c + this.f7991a);
        }
        return 0;
    }

    public final boolean e() {
        int c = c(28);
        return (c == 0 || this.b.get(c + this.f7991a) == 0) ? false : true;
    }

    public final int f() {
        int c = c(30);
        if (c != 0) {
            return f(c);
        }
        return 0;
    }

    public final boolean g() {
        int c = c(36);
        return (c == 0 || this.b.get(c + this.f7991a) == 0) ? false : true;
    }

    public final int h() {
        int c = c(40);
        if (c != 0) {
            return f(c);
        }
        return 0;
    }

    public final boolean i() {
        int c = c(42);
        return (c == 0 || this.b.get(c + this.f7991a) == 0) ? false : true;
    }

    public final byte j() {
        int c = c(46);
        if (c != 0) {
            return this.b.get(c + this.f7991a);
        }
        return (byte) 0;
    }
}
