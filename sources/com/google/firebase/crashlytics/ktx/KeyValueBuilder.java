package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0007J\u001d\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\tJ\u001d\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\u000bJ\u001d\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\u0003\u0010\rJ\u001d\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e¢\u0006\u0004\b\u0003\u0010\u000fJ\u001d\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/google/firebase/crashlytics/ktx/KeyValueBuilder;", "", "", "key", "", "value", "", "(Ljava/lang/String;Z)V", "", "(Ljava/lang/String;D)V", "", "(Ljava/lang/String;F)V", "", "(Ljava/lang/String;I)V", "", "(Ljava/lang/String;J)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "<init>", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;)V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics firebaseCrashlytics) {
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "");
        this.crashlytics = firebaseCrashlytics;
    }

    public final void key(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.crashlytics.setCustomKey(key, value);
    }

    public final void key(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.crashlytics.setCustomKey(key, value);
    }

    public final void key(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.crashlytics.setCustomKey(key, value);
    }

    public final void key(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.crashlytics.setCustomKey(key, value);
    }

    public final void key(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.crashlytics.setCustomKey(key, value);
    }

    public final void key(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(value, "");
        this.crashlytics.setCustomKey(key, value);
    }
}
