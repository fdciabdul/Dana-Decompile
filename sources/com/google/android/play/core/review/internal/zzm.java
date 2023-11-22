package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzm extends zzj {
    final /* synthetic */ zzj zza;
    final /* synthetic */ zzt zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzt zztVar, TaskCompletionSource taskCompletionSource, zzj zzjVar) {
        super(taskCompletionSource);
        this.zzb = zztVar;
        this.zza = zzjVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        zzt.zzm(this.zzb, this.zza);
    }
}
