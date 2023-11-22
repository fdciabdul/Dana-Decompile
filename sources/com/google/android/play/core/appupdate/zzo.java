package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes3.dex */
class zzo extends com.google.android.play.core.appupdate.internal.zzg {
    final com.google.android.play.core.appupdate.internal.zzm zza;
    final TaskCompletionSource zzb;
    final /* synthetic */ zzr zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzr zzrVar, com.google.android.play.core.appupdate.internal.zzm zzmVar, TaskCompletionSource taskCompletionSource) {
        this.zzc = zzrVar;
        this.zza = zzmVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzb(Bundle bundle) throws RemoteException {
        this.zzc.zza.zzr(this.zzb);
        this.zza.zzd("onCompleteUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzc(Bundle bundle) throws RemoteException {
        this.zzc.zza.zzr(this.zzb);
        this.zza.zzd("onRequestInfo", new Object[0]);
    }
}
