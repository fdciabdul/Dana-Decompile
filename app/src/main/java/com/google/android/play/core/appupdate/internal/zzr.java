package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzr extends zzn {
    final /* synthetic */ zzx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzx zzxVar) {
        this.zza = zzxVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        IInterface iInterface;
        zzm zzmVar;
        Context context;
        ServiceConnection serviceConnection;
        zzx zzxVar = this.zza;
        iInterface = zzxVar.zzn;
        if (iInterface != null) {
            zzmVar = zzxVar.zzc;
            zzmVar.zzd("Unbind from service.", new Object[0]);
            zzx zzxVar2 = this.zza;
            context = zzxVar2.zzb;
            serviceConnection = zzxVar2.zzm;
            context.unbindService(serviceConnection);
            this.zza.zzh = false;
            this.zza.zzn = null;
            this.zza.zzm = null;
        }
        this.zza.zzt();
    }
}
