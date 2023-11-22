package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes7.dex */
final class zzaa extends com.google.android.gms.maps.internal.zzaq {
    final /* synthetic */ GoogleMap.OnMapLongClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(GoogleMap googleMap, GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.zza = onMapLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzar
    public final void zzb(LatLng latLng) {
        this.zza.onMapLongClick(latLng);
    }
}
