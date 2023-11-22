package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polygon;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzo extends zzbg {
    final /* synthetic */ GoogleMap.OnPolygonClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(GoogleMap googleMap, GoogleMap.OnPolygonClickListener onPolygonClickListener) {
        this.zza = onPolygonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbh
    public final void zzb(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.zza.onPolygonClick(new Polygon(zzagVar));
    }
}
