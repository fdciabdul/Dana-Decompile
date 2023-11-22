package com.google.android.gms.internal.auth;

import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzcx extends zzdc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcx(zzcz zzczVar, String str, Double d, boolean z) {
        super(zzczVar, str, d, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            InstrumentInjector.log_e("PhenotypeFlag", "Invalid double value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
