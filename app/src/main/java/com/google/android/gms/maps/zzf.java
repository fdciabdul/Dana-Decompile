package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzf extends com.google.android.gms.maps.internal.zzh {
    final /* synthetic */ GoogleMap.InfoWindowAdapter zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(GoogleMap googleMap, GoogleMap.InfoWindowAdapter infoWindowAdapter) {
        this.zza = infoWindowAdapter;
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final IObjectWrapper zzb(com.google.android.gms.internal.maps.zzad zzadVar) {
        return ObjectWrapper.wrap(this.zza.getInfoContents(new Marker(zzadVar)));
    }

    @Override // com.google.android.gms.maps.internal.zzi
    public final IObjectWrapper zzc(com.google.android.gms.internal.maps.zzad zzadVar) {
        return ObjectWrapper.wrap(this.zza.getInfoWindow(new Marker(zzadVar)));
    }
}
