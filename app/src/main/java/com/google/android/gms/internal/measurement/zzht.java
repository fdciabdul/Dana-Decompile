package com.google.android.gms.internal.measurement;

import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzht extends zzia {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzht(zzhx zzhxVar, String str, Long l, boolean z) {
        super(zzhxVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            InstrumentInjector.log_e("PhenotypeFlag", "Invalid long value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
