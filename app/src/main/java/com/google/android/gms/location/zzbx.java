package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* loaded from: classes7.dex */
public final class zzbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbx> CREATOR = new zzby();
    private final List zza;
    private final PendingIntent zzb;
    private final String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbx(List list, PendingIntent pendingIntent, String str) {
        com.google.android.gms.internal.location.zzbx zzj;
        if (list == null) {
            zzj = com.google.android.gms.internal.location.zzbx.zzk();
        } else {
            zzj = com.google.android.gms.internal.location.zzbx.zzj(list);
        }
        this.zza = zzj;
        this.zzb = pendingIntent;
        this.zzc = str;
    }

    public static zzbx zza(List list) {
        Preconditions.checkNotNull(list, "geofence can't be null.");
        Preconditions.checkArgument(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzbx(list, null, "");
    }

    public static zzbx zzb(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent, "PendingIntent can not be null.");
        return new zzbx(null, pendingIntent, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
