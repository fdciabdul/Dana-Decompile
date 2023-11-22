package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
final class zzq extends zzan {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ CountDownLatch zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzz zzzVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.zza = atomicReference;
        this.zzb = countDownLatch;
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void zzb(Status status, Location location) {
        if (status.isSuccess()) {
            this.zza.set(location);
        }
        this.zzb.countDown();
    }
}
