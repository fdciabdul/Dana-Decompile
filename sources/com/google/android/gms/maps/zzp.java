package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbi;
import com.google.android.gms.maps.model.Polyline;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzp extends zzbi {
    final /* synthetic */ GoogleMap.OnPolylineClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(GoogleMap googleMap, GoogleMap.OnPolylineClickListener onPolylineClickListener) {
        this.zza = onPolylineClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbj
    public final void zzb(com.google.android.gms.internal.maps.zzaj zzajVar) {
        this.zza.onPolylineClick(new Polyline(zzajVar));
    }
}
