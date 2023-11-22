package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzm extends com.google.android.play.core.appupdate.internal.zzn {
    final /* synthetic */ String zza;
    final /* synthetic */ TaskCompletionSource zzb;
    final /* synthetic */ zzr zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzc = zzrVar;
        this.zza = str;
        this.zzb = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.appupdate.internal.zzf, android.os.IInterface] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        com.google.android.play.core.appupdate.internal.zzm zzmVar;
        String str;
        try {
            ?? zze = this.zzc.zza.zze();
            zzr zzrVar = this.zzc;
            str = zzrVar.zzd;
            zze.zzd(str, zzr.zzb(zzrVar, this.zza), new zzq(this.zzc, this.zzb, this.zza));
        } catch (RemoteException e) {
            zzmVar = zzr.zzb;
            zzmVar.zzc(e, "requestUpdateInfo(%s)", this.zza);
            this.zzb.trySetException(new RuntimeException(e));
        }
    }
}
