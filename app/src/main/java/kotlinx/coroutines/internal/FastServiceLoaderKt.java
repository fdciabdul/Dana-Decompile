package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001a\u0010\u0001\u001a\u00020\u00008\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004"}, d2 = {"", "ANDROID_DETECTED", "Z", "getANDROID_DETECTED", "()Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object m3179constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m3186isSuccessimpl(m3179constructorimpl);
    }

    @JvmName(name = "getANDROID_DETECTED")
    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
