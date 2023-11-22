package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzz extends com.google.android.gms.maps.internal.zzam {
    final /* synthetic */ GoogleMap.OnMapClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(GoogleMap googleMap, GoogleMap.OnMapClickListener onMapClickListener) {
        this.zza = onMapClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzan
    public final void zzb(LatLng latLng) {
        this.zza.onMapClick(latLng);
    }
}
