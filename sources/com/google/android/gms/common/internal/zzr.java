package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzr implements Handler.Callback {
    final /* synthetic */ zzs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzr(zzs zzsVar, zzq zzqVar) {
        this.zza = zzsVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i = message.what;
        if (i == 0) {
            hashMap = this.zza.zzb;
            synchronized (hashMap) {
                zzo zzoVar = (zzo) message.obj;
                hashMap2 = this.zza.zzb;
                zzp zzpVar = (zzp) hashMap2.get(zzoVar);
                if (zzpVar != null && zzpVar.zzi()) {
                    if (zzpVar.zzj()) {
                        zzpVar.zzg("GmsClientSupervisor");
                    }
                    hashMap3 = this.zza.zzb;
                    hashMap3.remove(zzoVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            hashMap4 = this.zza.zzb;
            synchronized (hashMap4) {
                zzo zzoVar2 = (zzo) message.obj;
                hashMap5 = this.zza.zzb;
                zzp zzpVar2 = (zzp) hashMap5.get(zzoVar2);
                if (zzpVar2 != null && zzpVar2.zza() == 3) {
                    InstrumentInjector.log_e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(zzoVar2), new Exception());
                    ComponentName zzb = zzpVar2.zzb();
                    if (zzb == null) {
                        zzb = zzoVar2.zza();
                    }
                    if (zzb == null) {
                        String zzc = zzoVar2.zzc();
                        Preconditions.checkNotNull(zzc);
                        zzb = new ComponentName(zzc, "unknown");
                    }
                    zzpVar2.onServiceDisconnected(zzb);
                }
            }
            return true;
        }
    }
}
