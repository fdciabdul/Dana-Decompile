package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzb extends com.google.android.gms.maps.internal.zzaw {
    final /* synthetic */ GoogleMap.OnMarkerDragListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(GoogleMap googleMap, GoogleMap.OnMarkerDragListener onMarkerDragListener) {
        this.zza = onMarkerDragListener;
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void zzb(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.zza.onMarkerDrag(new Marker(zzadVar));
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void zzc(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.zza.onMarkerDragEnd(new Marker(zzadVar));
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void zzd(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.zza.onMarkerDragStart(new Marker(zzadVar));
    }
}
