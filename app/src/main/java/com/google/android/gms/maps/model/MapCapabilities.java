package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes7.dex */
public final class MapCapabilities {
    private final com.google.android.gms.internal.maps.zzaa zza;

    public MapCapabilities(com.google.android.gms.internal.maps.zzaa zzaaVar) {
        this.zza = (com.google.android.gms.internal.maps.zzaa) Preconditions.checkNotNull(zzaaVar);
    }

    public final boolean isAdvancedMarkersAvailable() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
