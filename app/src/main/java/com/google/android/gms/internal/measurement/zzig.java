package com.google.android.gms.internal.measurement;

import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzig extends zzif {
    private final Object zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzig(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzig) {
            return this.zza.equals(((zzig) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza + ")";
    }

    @Override // com.google.android.gms.internal.measurement.zzif
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzif
    public final boolean zzb() {
        return true;
    }
}
