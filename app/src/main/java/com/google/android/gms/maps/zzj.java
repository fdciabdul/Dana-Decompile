package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzj extends com.google.android.gms.maps.internal.zzao {
    final /* synthetic */ GoogleMap.OnMapLoadedCallback zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.zza = onMapLoadedCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zzb() throws RemoteException {
        this.zza.onMapLoaded();
    }
}
