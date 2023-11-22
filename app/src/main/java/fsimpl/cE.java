package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class cE extends fn {
    public final cB a(cB cBVar) {
        int c = c(10);
        if (c != 0) {
            return cBVar.b(d(c + this.f7991a), this.b);
        }
        return null;
    }

    public final C0289cm a(C0289cm c0289cm) {
        int c = c(16);
        if (c != 0) {
            return c0289cm.b(d(c + this.f7991a), this.b);
        }
        return null;
    }

    public final String a() {
        int c = c(4);
        if (c != 0) {
            return e(c + this.f7991a);
        }
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public final cE b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public final String b() {
        int c = c(8);
        if (c != 0) {
            return e(c + this.f7991a);
        }
        return null;
    }

    public final cB c() {
        return a(new cB());
    }

    public final boolean d() {
        int c = c(14);
        return (c == 0 || this.b.get(c + this.f7991a) == 0) ? false : true;
    }

    public final C0289cm e() {
        return a(new C0289cm());
    }

    public final boolean f() {
        int c = c(24);
        return (c == 0 || this.b.get(c + this.f7991a) == 0) ? false : true;
    }

    public final byte g() {
        int c = c(26);
        if (c != 0) {
            return this.b.get(c + this.f7991a);
        }
        return (byte) 0;
    }
}
