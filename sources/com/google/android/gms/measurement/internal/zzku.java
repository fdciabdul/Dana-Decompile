package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzku implements zzlg {
    final /* synthetic */ zzkz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzku(zzkz zzkzVar) {
        this.zza = zzkzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlg
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzaz().zzp(new zzkt(this, str, "_err", bundle));
            return;
        }
        zzkz zzkzVar = this.zza;
        if (zzkz.zzp(zzkzVar) != null) {
            zzkz.zzp(zzkzVar).zzay().zzd().zzb("AppId not known when logging event", "_err");
        }
    }
}
