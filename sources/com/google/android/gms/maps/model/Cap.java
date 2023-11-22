package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes7.dex */
public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();
    private static final String zza = "Cap";
    private final int zzb;
    private final BitmapDescriptor zzc;
    private final Float zzd;

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(int i) {
        this(i, (BitmapDescriptor) null, (Float) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cap) {
            Cap cap = (Cap) obj;
            return this.zzb == cap.zzb && Objects.equal(this.zzc, cap.zzc) && Objects.equal(this.zzd, cap.zzd);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Cap: type=");
        sb.append(this.zzb);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i2);
        BitmapDescriptor bitmapDescriptor = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.zza().asBinder(), false);
        SafeParcelWriter.writeFloatObject(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Cap zza() {
        int i = this.zzb;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        Preconditions.checkState(this.zzc != null, "bitmapDescriptor must not be null");
                        Preconditions.checkState(this.zzd != null, "bitmapRefWidth must not be null");
                        return new CustomCap(this.zzc, this.zzd.floatValue());
                    }
                    String str = zza;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown Cap type: ");
                    sb.append(i);
                    InstrumentInjector.log_w(str, sb.toString());
                    return this;
                }
                return new RoundCap();
            }
            return new SquareCap();
        }
        return new ButtCap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cap(int i, IBinder iBinder, Float f) {
        this(i, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder)), f);
    }

    private Cap(int i, BitmapDescriptor bitmapDescriptor, Float f) {
        boolean z;
        boolean z2 = f != null && f.floatValue() > 0.0f;
        if (i == 3) {
            if (bitmapDescriptor == null || !z2) {
                i = 3;
                z = false;
                Preconditions.checkArgument(z, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i), bitmapDescriptor, f));
                this.zzb = i;
                this.zzc = bitmapDescriptor;
                this.zzd = f;
            }
            i = 3;
        }
        z = true;
        Preconditions.checkArgument(z, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i), bitmapDescriptor, f));
        this.zzb = i;
        this.zzc = bitmapDescriptor;
        this.zzd = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(BitmapDescriptor bitmapDescriptor, float f) {
        this(3, bitmapDescriptor, Float.valueOf(f));
    }
}
