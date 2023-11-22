package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes7.dex */
public final class zzk {
    private long zza = Long.MIN_VALUE;

    public final zzk zza(long j) {
        Preconditions.checkArgument(j >= 0, "intervalMillis can't be negative.");
        this.zza = j;
        return this;
    }

    public final zzl zzb() {
        Preconditions.checkState(this.zza != Long.MIN_VALUE, "Must set intervalMillis.");
        return new zzl(this.zza, true, null, null, null, false, null, 0L, null);
    }
}
