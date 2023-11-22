package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes7.dex */
final class zze extends com.google.android.gms.maps.internal.zzae {
    final /* synthetic */ GoogleMap.OnInfoWindowCloseListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(GoogleMap googleMap, GoogleMap.OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.zza = onInfoWindowCloseListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaf
    public final void zzb(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.zza.onInfoWindowClose(new Marker(zzadVar));
    }
}
