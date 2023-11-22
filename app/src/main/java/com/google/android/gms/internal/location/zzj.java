package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes3.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    final int zza;
    final zzh zzb;
    final com.google.android.gms.location.zzbf zzc;
    final zzai zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(int i, zzh zzhVar, IBinder iBinder, IBinder iBinder2) {
        this.zza = i;
        this.zzb = zzhVar;
        zzai zzaiVar = null;
        this.zzc = iBinder == null ? null : com.google.android.gms.location.zzbe.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzaiVar = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzag(iBinder2);
        }
        this.zzd = zzaiVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        com.google.android.gms.location.zzbf zzbfVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzbfVar == null ? null : zzbfVar.asBinder(), false);
        zzai zzaiVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 4, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
