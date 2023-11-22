package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzc extends com.google.android.gms.maps.internal.zzac {
    final /* synthetic */ GoogleMap.OnInfoWindowClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(GoogleMap googleMap, GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.zza = onInfoWindowClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzad
    public final void zzb(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.zza.onInfoWindowClick(new Marker(zzadVar));
    }
}
