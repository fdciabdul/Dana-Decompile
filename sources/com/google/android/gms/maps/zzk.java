package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;

/* loaded from: classes7.dex */
final class zzk extends com.google.android.gms.maps.internal.zzaa {
    final /* synthetic */ GoogleMap.OnIndoorStateChangeListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(GoogleMap googleMap, GoogleMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.zza = onIndoorStateChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zzb() {
        this.zza.onIndoorBuildingFocused();
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zzc(com.google.android.gms.internal.maps.zzu zzuVar) {
        this.zza.onIndoorLevelActivated(new IndoorBuilding(zzuVar));
    }
}
