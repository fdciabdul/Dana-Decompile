package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public final class zzhr implements zzlg {
    final /* synthetic */ zzid zza;

    public zzhr(zzid zzidVar) {
        this.zza = zzidVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlg
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzF("auto", "_err", bundle, str);
        } else {
            this.zza.zzD("auto", "_err", bundle);
        }
    }
}
