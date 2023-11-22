package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes3.dex */
public final class zzh implements zzaf {
    private final zzaf zza;
    private final zzaf zzb;
    private final zzaf zzc;

    public zzh(zzaf zzafVar, zzaf zzafVar2, zzaf zzafVar3) {
        this.zza = zzafVar;
        this.zzb = zzafVar2;
        this.zzc = zzafVar3;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final /* synthetic */ Object zza() {
        return new zzg((zzr) this.zza.zza(), (zzc) this.zzb.zza(), ((zzk) this.zzc).zzb());
    }
}
