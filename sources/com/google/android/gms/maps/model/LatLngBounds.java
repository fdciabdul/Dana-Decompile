package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.GoogleMapOptions;

/* loaded from: classes3.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzi();
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private double zza = Double.POSITIVE_INFINITY;
        private double zzb = Double.NEGATIVE_INFINITY;
        private double zzc = Double.NaN;
        private double zzd = Double.NaN;

        public final LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.zzc), "no included points");
            return new LatLngBounds(new LatLng(this.zza, this.zzc), new LatLng(this.zzb, this.zzd));
        }

        public final Builder include(LatLng latLng) {
            Preconditions.checkNotNull(latLng, "point must not be null");
            this.zza = Math.min(this.zza, latLng.latitude);
            this.zzb = Math.max(this.zzb, latLng.latitude);
            double d = latLng.longitude;
            if (!Double.isNaN(this.zzc)) {
                double d2 = this.zzc;
                double d3 = this.zzd;
                if (d2 > d3 ? !(d2 <= d || d <= d3) : !(d2 <= d && d <= d3)) {
                    if (((d2 - d) + 360.0d) % 360.0d < ((d - this.zzd) + 360.0d) % 360.0d) {
                        this.zzc = d;
                    }
                }
                return this;
            }
            this.zzc = d;
            this.zzd = d;
            return this;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Preconditions.checkNotNull(latLng, "southwest must not be null.");
        Preconditions.checkNotNull(latLng2, "northeast must not be null.");
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        Preconditions.checkArgument(d >= d2, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d2), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zzb(context, attributeSet);
    }

    private final boolean zza(double d) {
        LatLng latLng = this.northeast;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    public final boolean contains(LatLng latLng) {
        LatLng latLng2 = (LatLng) Preconditions.checkNotNull(latLng, "point must not be null.");
        double d = latLng2.latitude;
        return this.southwest.latitude <= d && d <= this.northeast.latitude && zza(latLng2.longitude);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
        }
        return false;
    }

    public final LatLng getCenter() {
        LatLng latLng = this.northeast;
        LatLng latLng2 = this.southwest;
        double d = latLng2.latitude;
        double d2 = latLng.latitude;
        double d3 = latLng.longitude;
        double d4 = latLng2.longitude;
        if (d4 > d3) {
            d3 += 360.0d;
        }
        return new LatLng((d + d2) / 2.0d, (d3 + d4) / 2.0d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2 = (LatLng) Preconditions.checkNotNull(latLng, "point must not be null.");
        double min = Math.min(this.southwest.latitude, latLng2.latitude);
        double max = Math.max(this.northeast.latitude, latLng2.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng2.longitude;
        if (!zza(d3)) {
            if (((d2 - d3) + 360.0d) % 360.0d < ((d3 - d) + 360.0d) % 360.0d) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        LatLng latLng = this.southwest;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, latLng, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.northeast, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
