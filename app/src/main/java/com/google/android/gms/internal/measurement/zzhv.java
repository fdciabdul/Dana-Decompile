package com.google.android.gms.internal.measurement;

import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzhv extends zzia {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhv(zzhx zzhxVar, String str, Double d, boolean z) {
        super(zzhxVar, "measurement.test.double_flag", d, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
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
