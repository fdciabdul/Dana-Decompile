package io.opentelemetry.sdk.metrics.internal.concurrent;

/* loaded from: classes6.dex */
public final class AdderUtil {
    private static final boolean hasJreAdder;

    static {
        boolean z;
        try {
            Class.forName("java.util.concurrent.atomic.DoubleAdder");
            Class.forName("java.util.concurrent.atomic.LongAdder");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        hasJreAdder = z;
    }

    public static LongAdder createLongAdder() {
        return hasJreAdder ? new JreLongAdder() : new AtomicLongLongAdder();
    }

    public static DoubleAdder createDoubleAdder() {
        return hasJreAdder ? new JreDoubleAdder() : new AtomicLongDoubleAdder();
    }

    private AdderUtil() {
    }
}
