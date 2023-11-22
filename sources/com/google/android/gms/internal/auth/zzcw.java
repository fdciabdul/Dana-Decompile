package com.google.android.gms.internal.auth;

import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzcw extends zzdc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcw(zzcz zzczVar, String str, Boolean bool, boolean z) {
        super(zzczVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzdc
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (zzcb.zzc.matcher(obj).matches()) {
            return true;
        }
        if (!zzcb.zzd.matcher(obj).matches()) {
            InstrumentInjector.log_e("PhenotypeFlag", "Invalid boolean value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
        return false;
    }
}
