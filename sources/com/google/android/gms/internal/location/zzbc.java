package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes3.dex */
final class zzbc extends com.google.android.gms.location.zzbk {
    private final ListenerHolder zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbc(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    public final void zzc() {
        synchronized (this) {
            this.zza.clear();
        }
    }

    @Override // com.google.android.gms.location.zzbl
    public final void zzd(Location location) {
        synchronized (this) {
            this.zza.notifyListener(new zzbb(this, location));
        }
    }
}
