package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes7.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
    private LatLng zza;
    private double zzb;
    private float zzc;
    private int zzd;
    private int zze;
    private float zzf;
    private boolean zzg;
    private boolean zzh;
    private List zzi;

    public CircleOptions() {
        this.zza = null;
        this.zzb = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.zzc = 10.0f;
        this.zzd = -16777216;
        this.zze = 0;
        this.zzf = 0.0f;
        this.zzg = true;
        this.zzh = false;
        this.zzi = null;
    }

    public final CircleOptions center(LatLng latLng) {
        Preconditions.checkNotNull(latLng, "center must not be null.");
        this.zza = latLng;
        return this;
    }

    public final CircleOptions clickable(boolean z) {
        this.zzh = z;
        return this;
    }

    public final CircleOptions fillColor(int i) {
        this.zze = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.zza;
    }

    public final int getFillColor() {
        return this.zze;
    }

    public final double getRadius() {
        return this.zzb;
    }

    public final int getStrokeColor() {
        return this.zzd;
    }

    public final List<PatternItem> getStrokePattern() {
        return this.zzi;
    }

    public final float getStrokeWidth() {
        return this.zzc;
    }

    public final float getZIndex() {
        return this.zzf;
    }

    public final boolean isClickable() {
        return this.zzh;
    }

    public final boolean isVisible() {
        return this.zzg;
    }

    public final CircleOptions radius(double d) {
        this.zzb = d;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.zzd = i;
        return this;
    }

    public final CircleOptions strokePattern(List<PatternItem> list) {
        this.zzi = list;
        return this;
    }

    public final CircleOptions strokeWidth(float f) {
        this.zzc = f;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.zzg = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getCenter(), i, false);
        SafeParcelWriter.writeDouble(parcel, 3, getRadius());
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isClickable());
        SafeParcelWriter.writeTypedList(parcel, 10, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final CircleOptions zIndex(float f) {
        this.zzf = f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleOptions(LatLng latLng, double d, float f, int i, int i2, float f2, boolean z, boolean z2, List list) {
        this.zza = latLng;
        this.zzb = d;
        this.zzc = f;
        this.zzd = i;
        this.zze = i2;
        this.zzf = f2;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = list;
    }
}
