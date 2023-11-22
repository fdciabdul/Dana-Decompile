package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes7.dex */
public abstract class zzal extends zzb implements zzam {
    public static zzam zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        return queryLocalInterface instanceof zzam ? (zzam) queryLocalInterface : new zzak(iBinder);
    }
}
