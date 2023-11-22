package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzfm extends LruCache {
    final /* synthetic */ zzfp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfp zzfpVar, int i) {
        super(20);
        this.zza = zzfpVar;
    }

    @Override // androidx.collection.LruCache
    public final /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfp.zzd(this.zza, str);
    }
}
