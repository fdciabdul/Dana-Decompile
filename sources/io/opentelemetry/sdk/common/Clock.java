package io.opentelemetry.sdk.common;

/* loaded from: classes.dex */
public interface Clock {
    long nanoTime();

    long now();

    /* renamed from: io.opentelemetry.sdk.common.Clock$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static Clock getDefault() {
            return SystemClock.getInstance();
        }
    }
}
