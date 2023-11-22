package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzf extends com.google.android.play.core.review.internal.zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(zzi zziVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzb = zziVar;
        this.zza = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.review.internal.zzf] */
    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        com.google.android.play.core.review.internal.zzi zziVar;
        String str;
        String str2;
        String str3;
        try {
            ?? zze = this.zzb.zza.zze();
            str2 = this.zzb.zzc;
            Bundle zza = zzj.zza();
            zzi zziVar2 = this.zzb;
            TaskCompletionSource taskCompletionSource = this.zza;
            str3 = zziVar2.zzc;
            zze.zzc(str2, zza, new zzh(zziVar2, taskCompletionSource, str3));
        } catch (RemoteException e) {
            zziVar = zzi.zzb;
            str = this.zzb.zzc;
            zziVar.zzc(e, "error requesting in-app review for %s", str);
            this.zza.trySetException(new RuntimeException(e));
        }
    }
}
