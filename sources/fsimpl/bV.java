package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class bV extends fn {
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

    public final byte b() {
        int c = c(6);
        if (c != 0) {
            return this.b.get(c + this.f7991a);
        }
        return (byte) 0;
    }

    public final bV b(int i, ByteBuffer byteBuffer) {
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
}
