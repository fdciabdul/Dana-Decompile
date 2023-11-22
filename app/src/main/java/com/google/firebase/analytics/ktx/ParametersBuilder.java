package com.google.firebase.analytics.ktx;

import android.os.Bundle;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/analytics/ktx/ParametersBuilder;", "", "()V", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "param", "", "key", "", "value", "", "(Ljava/lang/String;[Landroid/os/Bundle;)V", "", "", "java.com.google.android.libraries.firebase.firebase_analytics_ktx_granule"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    /* renamed from: getBundle  reason: from getter */
    public final Bundle getZza() {
        return this.zza;
    }

    public final void param(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.zza.putDouble(key, value);
    }

    public final void param(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.zza.putLong(key, value);
    }

    public final void param(String key, Bundle value) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(value, "");
        this.zza.putBundle(key, value);
    }

    public final void param(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(value, "");
        this.zza.putString(key, value);
    }

    public final void param(String key, Bundle[] value) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(value, "");
        this.zza.putParcelableArray(key, value);
    }
}
