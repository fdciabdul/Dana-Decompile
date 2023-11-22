package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes7.dex */
public final class zzn extends zzb implements zzo {
    public static zzo zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IFeatureLayerDelegate");
        return queryLocalInterface instanceof zzo ? (zzo) queryLocalInterface : new zzm(iBinder);
    }
}
