package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes3.dex */
public final class zzs implements zzaf {
    private final zzaf zza;
    private final zzaf zzb;

    public zzs(zzaf zzafVar, zzaf zzafVar2) {
        this.zza = zzafVar;
        this.zzb = zzafVar2;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final /* synthetic */ Object zza() {
        return new zzr(((zzk) this.zza).zzb(), (zzt) this.zzb.zza());
    }
}
