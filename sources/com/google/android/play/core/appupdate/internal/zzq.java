package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzq extends zzn {
    final /* synthetic */ zzn zza;
    final /* synthetic */ zzx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzx zzxVar, TaskCompletionSource taskCompletionSource, zzn zznVar) {
        super(taskCompletionSource);
        this.zzb = zzxVar;
        this.zza = zznVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        zzx.zzm(this.zzb, this.zza);
    }
}
