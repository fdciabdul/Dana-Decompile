package fsimpl;

import java.nio.ByteBuffer;

/* renamed from: fsimpl.ct  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0296ct extends fn {
    public final bY a(bY bYVar) {
        int c = c(8);
        if (c != 0) {
            return bYVar.b(d(c + this.f7991a), this.b);
        }
        return null;
    }

    public final short a() {
        int c = c(4);
        if (c != 0) {
            return this.b.getShort(c + this.f7991a);
        }
        return (short) 0;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public final bY b() {
        return a(new bY());
    }

    public final C0296ct b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public final byte c() {
        int c = c(12);
        if (c != 0) {
            return this.b.get(c + this.f7991a);
        }
        return (byte) 0;
    }
}
