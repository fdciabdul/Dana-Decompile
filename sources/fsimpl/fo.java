package fsimpl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class fo {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f7992a = !fo.class.desiredAssertionStatus();
    private static fo b;

    public static fo a() {
        if (b == null) {
            b = new fq();
        }
        return b;
    }

    public abstract int a(CharSequence charSequence);

    public abstract String a(ByteBuffer byteBuffer, int i, int i2);

    public abstract void a(CharSequence charSequence, ByteBuffer byteBuffer);
}
