package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzee;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzb implements Callable {
    final /* synthetic */ FirebaseAnalytics zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        zzee zzeeVar;
        zzeeVar = this.zza.zzb;
        return zzeeVar.zzk();
    }
}
