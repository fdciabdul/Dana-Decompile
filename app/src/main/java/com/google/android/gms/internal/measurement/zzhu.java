package com.google.android.gms.internal.measurement;

import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzhu extends zzia {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhu(zzhx zzhxVar, String str, Boolean bool, boolean z) {
        super(zzhxVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzia
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (zzgz.zzc.matcher(obj).matches()) {
            return true;
        }
        if (!zzgz.zzd.matcher(obj).matches()) {
            InstrumentInjector.log_e("PhenotypeFlag", "Invalid boolean value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
        return false;
    }
}
