package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes7.dex */
public final class IndoorBuilding {
    private final com.google.android.gms.internal.maps.zzu zza;
    private final zzh zzb;

    public IndoorBuilding(com.google.android.gms.internal.maps.zzu zzuVar) {
        zzh zzhVar = zzh.zza;
        this.zza = (com.google.android.gms.internal.maps.zzu) Preconditions.checkNotNull(zzuVar, "delegate");
        this.zzb = (zzh) Preconditions.checkNotNull(zzhVar, "shim");
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof IndoorBuilding) {
            try {
                return this.zza.zzh(((IndoorBuilding) obj).zza);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return false;
    }

    public final int getActiveLevelIndex() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getDefaultLevelIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<IndoorLevel> getLevels() {
        try {
            List zzg = this.zza.zzg();
            ArrayList arrayList = new ArrayList(zzg.size());
            Iterator it = zzg.iterator();
            while (it.hasNext()) {
                arrayList.add(new IndoorLevel(com.google.android.gms.internal.maps.zzw.zzb((IBinder) it.next())));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isUnderground() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
