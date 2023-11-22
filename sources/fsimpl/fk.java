package fsimpl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class fk extends fj {

    /* renamed from: a  reason: collision with root package name */
    public static final fk f7990a = new fk();

    @Override // fsimpl.fj
    public final ByteBuffer a(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }
}
