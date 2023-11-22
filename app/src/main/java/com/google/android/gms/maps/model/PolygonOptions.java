package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzq();
    private final List zza;
    private final List zzb;
    private float zzc;
    private int zzd;
    private int zze;
    private float zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private List zzk;

    public PolygonOptions() {
        this.zzc = 10.0f;
        this.zzd = -16777216;
        this.zze = 0;
        this.zzf = 0.0f;
        this.zzg = true;
        this.zzh = false;
        this.zzi = false;
        this.zzj = 0;
        this.zzk = null;
        this.zza = new ArrayList();
        this.zzb = new ArrayList();
    }

    public final PolygonOptions add(LatLng latLng) {
        Preconditions.checkNotNull(latLng, "point must not be null.");
        this.zza.add(latLng);
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.zza.add(it.next());
        }
        return this;
    }

    public final PolygonOptions addHole(Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.zzb.add(arrayList);
        return this;
    }

    public final PolygonOptions clickable(boolean z) {
        this.zzi = z;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.zze = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean z) {
        this.zzh = z;
        return this;
    }

    public final int getFillColor() {
        return this.zze;
    }

    public final List<List<LatLng>> getHoles() {
        return this.zzb;
    }

    public final List<LatLng> getPoints() {
        return this.zza;
    }

    public final int getStrokeColor() {
        return this.zzd;
    }

    public final int getStrokeJointType() {
        return this.zzj;
    }

    public final List<PatternItem> getStrokePattern() {
        return this.zzk;
    }

    public final float getStrokeWidth() {
        return this.zzc;
    }

    public final float getZIndex() {
        return this.zzf;
    }

    public final boolean isClickable() {
        return this.zzi;
    }

    public final boolean isGeodesic() {
        return this.zzh;
    }

    public final boolean isVisible() {
        return this.zzg;
    }

    public final PolygonOptions strokeColor(int i) {
        this.zzd = i;
        return this;
    }

    public final PolygonOptions strokeJointType(int i) {
        this.zzj = i;
        return this;
    }

    public final PolygonOptions strokePattern(List<PatternItem> list) {
        this.zzk = list;
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        this.zzc = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.zzg = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeList(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 10, isClickable());
        SafeParcelWriter.writeInt(parcel, 11, getStrokeJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final PolygonOptions zIndex(float f) {
        this.zzf = f;
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        Preconditions.checkNotNull(latLngArr, "points must not be null.");
        this.zza.addAll(Arrays.asList(latLngArr));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonOptions(List list, List list2, float f, int i, int i2, float f2, boolean z, boolean z2, boolean z3, int i3, List list3) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = f;
        this.zzd = i;
        this.zze = i2;
        this.zzf = f2;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = i3;
        this.zzk = list3;
    }
}
