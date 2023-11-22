package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes3.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzbm();
    private final long zza;
    private final int zzb;
    private final boolean zzc;

    /* loaded from: classes3.dex */
    public static class Builder {
        private long zza;
        private int zzb;
        private boolean zzc;

        public Builder() {
            this.zza = LongCompanionObject.MAX_VALUE;
            this.zzb = 0;
            this.zzc = false;
        }

        public Builder(LastLocationRequest lastLocationRequest) {
            this.zza = lastLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = lastLocationRequest.getGranularity();
            this.zzc = lastLocationRequest.zza();
        }

        public LastLocationRequest build() {
            return new LastLocationRequest(this.zza, this.zzb, this.zzc);
        }

        public Builder setGranularity(int i) {
            zzbc.zza(i);
            this.zzb = i;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j) {
            Preconditions.checkArgument(j > 0, "maxUpdateAgeMillis must be greater than 0");
            this.zza = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LastLocationRequest(long j, int i, boolean z) {
        this.zza = j;
        this.zzb = i;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LastLocationRequest) {
            LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
            return this.zza == lastLocationRequest.zza && this.zzb == lastLocationRequest.zzb && this.zzc == lastLocationRequest.zzc;
        }
        return false;
    }

    public final int getGranularity() {
        return this.zzb;
    }

    public final long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LastLocationRequest[");
        if (this.zza != LongCompanionObject.MAX_VALUE) {
            sb.append("maxAge=");
            com.google.android.gms.internal.location.zzbo.zza(this.zza, sb);
        }
        if (this.zzb != 0) {
            sb.append(", ");
            sb.append(zzbc.zzb(this.zzb));
        }
        if (this.zzc) {
            sb.append(", bypass");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.zzc;
    }
}
