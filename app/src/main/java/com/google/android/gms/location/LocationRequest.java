package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes3.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzbo();
    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;
    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    int zza;
    long zzb;
    long zzc;
    boolean zzd;
    long zze;
    int zzf;
    float zzg;
    long zzh;
    boolean zzi;

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, false, LongCompanionObject.MAX_VALUE, Integer.MAX_VALUE, 0.0f, 0L, false);
    }

    public static LocationRequest create() {
        return new LocationRequest(102, 3600000L, 600000L, false, LongCompanionObject.MAX_VALUE, Integer.MAX_VALUE, 0.0f, 0L, true);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            return this.zza == locationRequest.zza && this.zzb == locationRequest.zzb && this.zzc == locationRequest.zzc && this.zzd == locationRequest.zzd && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && getMaxWaitTime() == locationRequest.getMaxWaitTime() && this.zzi == locationRequest.zzi;
        }
        return false;
    }

    public final long getExpirationTime() {
        return this.zze;
    }

    public final long getFastestInterval() {
        return this.zzc;
    }

    public final long getInterval() {
        return this.zzb;
    }

    public final long getMaxWaitTime() {
        long j = this.zzh;
        long j2 = this.zzb;
        return j < j2 ? j2 : j;
    }

    public final int getNumUpdates() {
        return this.zzf;
    }

    public final int getPriority() {
        return this.zza;
    }

    public final float getSmallestDisplacement() {
        return this.zzg;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzg), Long.valueOf(this.zzh));
    }

    public final boolean isFastestIntervalExplicitlySet() {
        return this.zzd;
    }

    public final boolean isWaitForAccurateLocation() {
        return this.zzi;
    }

    public final LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j <= LongCompanionObject.MAX_VALUE - elapsedRealtime) {
            j2 = j + elapsedRealtime;
        }
        this.zze = j2;
        if (j2 < 0) {
            this.zze = 0L;
        }
        return this;
    }

    @Deprecated
    public final LocationRequest setExpirationTime(long j) {
        this.zze = j;
        if (j < 0) {
            this.zze = 0L;
        }
        return this;
    }

    public final LocationRequest setFastestInterval(long j) {
        Preconditions.checkArgument(j >= 0, "illegal fastest interval: %d", Long.valueOf(j));
        this.zzd = true;
        this.zzc = j;
        return this;
    }

    public final LocationRequest setInterval(long j) {
        Preconditions.checkArgument(j >= 0, "illegal interval: %d", Long.valueOf(j));
        this.zzb = j;
        if (!this.zzd) {
            double d = j;
            Double.isNaN(d);
            this.zzc = (long) (d / 6.0d);
        }
        return this;
    }

    public final LocationRequest setMaxWaitTime(long j) {
        Preconditions.checkArgument(j >= 0, "illegal max wait time: %d", Long.valueOf(j));
        this.zzh = j;
        return this;
    }

    public final LocationRequest setNumUpdates(int i) {
        if (i > 0) {
            this.zzf = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid numUpdates: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public final LocationRequest setPriority(int i) {
        boolean z;
        if (i != 100 && i != 102 && i != 104) {
            if (i != 105) {
                z = false;
                Preconditions.checkArgument(z, "illegal priority: %d", Integer.valueOf(i));
                this.zza = i;
                return this;
            }
            i = 105;
        }
        z = true;
        Preconditions.checkArgument(z, "illegal priority: %d", Integer.valueOf(i));
        this.zza = i;
        return this;
    }

    public final LocationRequest setSmallestDisplacement(float f) {
        if (f >= 0.0f) {
            this.zzg = f;
            return this;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f);
        throw new IllegalArgumentException(sb.toString());
    }

    public final LocationRequest setWaitForAccurateLocation(boolean z) {
        this.zzi = z;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i = this.zza;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.zza != 105) {
            sb.append(" requested=");
            sb.append(this.zzb);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzc);
        sb.append("ms");
        if (this.zzh > this.zzb) {
            sb.append(" maxWait=");
            sb.append(this.zzh);
            sb.append("ms");
        }
        if (this.zzg > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.zzg);
            sb.append("m");
        }
        long j = this.zze;
        if (j != LongCompanionObject.MAX_VALUE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j - elapsedRealtime);
            sb.append("ms");
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.zzf);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4, boolean z2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = j3;
        this.zzf = i2;
        this.zzg = f;
        this.zzh = j4;
        this.zzi = z2;
    }
}
