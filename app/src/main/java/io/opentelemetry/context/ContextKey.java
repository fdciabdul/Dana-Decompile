package io.opentelemetry.context;

import com.android.tools.r8.annotations.SynthesizedClassV2;

/* loaded from: classes6.dex */
public interface ContextKey<T> {

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.context.ContextKey$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<T> {
        public static <T> ContextKey<T> named(String str) {
            return new DefaultContextKey(str);
        }
    }
}
