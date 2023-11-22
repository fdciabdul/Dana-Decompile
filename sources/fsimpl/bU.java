package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class bU extends fn {
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

    public final bU b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public final byte c() {
        int c = c(8);
        if (c != 0) {
            return this.b.get(c + this.f7991a);
        }
        return (byte) 0;
    }
}
