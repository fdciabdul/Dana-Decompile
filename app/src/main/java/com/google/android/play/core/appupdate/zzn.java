package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzn extends com.google.android.play.core.appupdate.internal.zzn {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzr zzrVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, String str) {
        super(taskCompletionSource);
        this.zzc = zzrVar;
        this.zza = taskCompletionSource2;
        this.zzb = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.appupdate.internal.zzf, android.os.IInterface] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        com.google.android.play.core.appupdate.internal.zzm zzmVar;
        String str;
        Bundle zzi;
        try {
            ?? zze = this.zzc.zza.zze();
            str = this.zzc.zzd;
            zzi = zzr.zzi();
            zze.zzc(str, zzi, new zzp(this.zzc, this.zza));
        } catch (RemoteException e) {
            zzmVar = zzr.zzb;
            zzmVar.zzc(e, "completeUpdate(%s)", this.zzb);
            this.zza.trySetException(new RuntimeException(e));
        }
    }
}
