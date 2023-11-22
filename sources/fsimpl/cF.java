package fsimpl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class cF extends fn {
    public static cF a(ByteBuffer byteBuffer) {
        return a(byteBuffer, new cF());
    }

    public static cF a(ByteBuffer byteBuffer, cF cFVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return cFVar.b(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public final cE a() {
        return a(new cE());
    }

    public final cE a(cE cEVar) {
        int c = c(10);
        if (c != 0) {
            return cEVar.b(d(c + this.f7991a), this.b);
        }
        return null;
    }

    public final void a(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public final cF b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }
}
