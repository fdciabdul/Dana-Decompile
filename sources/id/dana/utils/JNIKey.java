package id.dana.utils;

import id.dana.utils.foundation.logger.log.DanaLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087 ¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/utils/JNIKey;", "", "", "severity1", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JNIKey {
    public static final JNIKey INSTANCE = new JNIKey();

    @JvmStatic
    public static final native String severity1();

    private JNIKey() {
    }

    static {
        try {
            System.loadLibrary("s64d21");
        } catch (UnsatisfiedLinkError unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(INSTANCE.getClass().getSimpleName(), "Cannot load jni class, maybe the JNI class has been moved");
        }
    }
}
