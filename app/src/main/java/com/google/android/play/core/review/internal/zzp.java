package com.google.android.play.core.review.internal;

import android.os.IBinder;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
final class zzp extends zzj {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzs zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzs zzsVar, IBinder iBinder) {
        this.zzb = zzsVar;
        this.zza = iBinder;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        List list;
        List list2;
        this.zzb.zza.zzn = zze.zzb(this.zza);
        zzt.zzn(this.zzb.zza);
        this.zzb.zza.zzh = false;
        list = this.zzb.zza.zze;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        list2 = this.zzb.zza.zze;
        list2.clear();
    }
}
