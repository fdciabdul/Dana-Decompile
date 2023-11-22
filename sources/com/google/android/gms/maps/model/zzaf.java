package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzaf implements TileProvider {
    final /* synthetic */ TileOverlayOptions zza;
    private final zzap zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(TileOverlayOptions tileOverlayOptions) {
        zzap zzapVar;
        this.zza = tileOverlayOptions;
        zzapVar = tileOverlayOptions.zza;
        this.zzb = zzapVar;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            return this.zzb.zzb(i, i2, i3);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
