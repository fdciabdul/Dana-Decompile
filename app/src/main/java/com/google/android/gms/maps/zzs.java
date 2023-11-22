package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MapCapabilities;

/* loaded from: classes7.dex */
final class zzs extends com.google.android.gms.maps.internal.zzak {
    final /* synthetic */ GoogleMap.OnMapCapabilitiesChangedListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(GoogleMap googleMap, GoogleMap.OnMapCapabilitiesChangedListener onMapCapabilitiesChangedListener) {
        this.zza = onMapCapabilitiesChangedListener;
    }

    @Override // com.google.android.gms.maps.internal.zzal
    public final void zzb(com.google.android.gms.internal.maps.zzaa zzaaVar) {
        this.zza.onMapCapabilitiesChanged(new MapCapabilities(zzaaVar));
    }
}
