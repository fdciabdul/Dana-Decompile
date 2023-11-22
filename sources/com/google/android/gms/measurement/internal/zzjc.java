package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
public final class zzjc extends zzap {
    final /* synthetic */ zzjs zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjc(zzjs zzjsVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzjsVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzjs zzjsVar = this.zza;
        zzjsVar.zzg();
        if (zzjsVar.zzL()) {
            zzjsVar.zzs.zzay().zzj().zza("Inactivity, disconnecting from the service");
            zzjsVar.zzs();
        }
    }
}
