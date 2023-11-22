package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
/* loaded from: classes7.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* loaded from: classes7.dex */
    public interface Types {
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public final String toString() {
        long zzb = zzb();
        int zza = zza();
        String zzc = zzc();
        StringBuilder sb = new StringBuilder();
        sb.append(zzb);
        sb.append("\t");
        sb.append(zza);
        sb.append("\t-1");
        sb.append(zzc);
        return sb.toString();
    }

    public abstract int zza();

    public abstract long zzb();

    public abstract String zzc();
}
