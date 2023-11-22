package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes3.dex */
public final class zzbh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();
    private final int zza;
    private final zzbf zzb;
    private final com.google.android.gms.location.zzbl zzc;
    private final com.google.android.gms.location.zzbi zzd;
    private final PendingIntent zze;
    private final zzai zzf;
    private final String zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(int i, zzbf zzbfVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.zza = i;
        this.zzb = zzbfVar;
        zzai zzaiVar = null;
        this.zzc = iBinder != null ? com.google.android.gms.location.zzbk.zzb(iBinder) : null;
        this.zze = pendingIntent;
        this.zzd = iBinder2 != null ? com.google.android.gms.location.zzbh.zzb(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzaiVar = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzag(iBinder3);
        }
        this.zzf = zzaiVar;
        this.zzg = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.location.zzbi, android.os.IBinder] */
    public static zzbh zza(com.google.android.gms.location.zzbi zzbiVar, zzai zzaiVar) {
        if (zzaiVar == null) {
            zzaiVar = null;
        }
        return new zzbh(2, null, null, zzbiVar, null, zzaiVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.location.zzbl, android.os.IBinder] */
    public static zzbh zzb(com.google.android.gms.location.zzbl zzblVar, zzai zzaiVar) {
        if (zzaiVar == null) {
            zzaiVar = null;
        }
        return new zzbh(2, null, zzblVar, null, null, zzaiVar, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        com.google.android.gms.location.zzbl zzblVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzblVar == null ? null : zzblVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zze, i, false);
        com.google.android.gms.location.zzbi zzbiVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 5, zzbiVar == null ? null : zzbiVar.asBinder(), false);
        zzai zzaiVar = this.zzf;
        SafeParcelWriter.writeIBinder(parcel, 6, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
