package com.google.android.play.core.appupdate.internal;

/* loaded from: classes3.dex */
public final class zzad implements zzaf {
    private static final Object zza = new Object();
    private volatile zzaf zzb;
    private volatile Object zzc = zza;

    private zzad(zzaf zzafVar) {
        this.zzb = zzafVar;
    }

    public static zzaf zzb(zzaf zzafVar) {
        return zzafVar instanceof zzad ? zzafVar : new zzad(zzafVar);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zza();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2 && obj3 != obj) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(obj3);
                        sb.append(" & ");
                        sb.append(obj);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
