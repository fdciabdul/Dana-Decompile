package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class zzgr implements zzgt {
    protected final zzfy zzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzfy zzfyVar) {
        Preconditions.checkNotNull(zzfyVar);
        this.zzs = zzfyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final Context zzau() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final Clock zzav() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final zzab zzaw() {
        throw null;
    }

    public void zzax() {
        this.zzs.zzaz().zzax();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final zzeo zzay() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final zzfv zzaz() {
        throw null;
    }

    public void zzg() {
        this.zzs.zzaz().zzg();
    }
}
