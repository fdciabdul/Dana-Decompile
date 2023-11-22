package id.dana.domain.globalsearch.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b'\u0010(B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b'\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010\u0006\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010$R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010!\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010$"}, d2 = {"Lid/dana/domain/globalsearch/model/LatLng;", "Landroid/os/Parcelable;", "", "component1", "()D", "component2", "latitude", "longitude", "copy", "(DD)Lid/dana/domain/globalsearch/model/LatLng;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lcom/google/android/gms/maps/model/LatLng;", "toGoogleLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "isUndefined", "()Z", SummaryActivity.DAYS, "getLatitude", "setLatitude", "(D)V", "getLongitude", "setLongitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(DD)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LatLng implements Parcelable {
    private double latitude;
    private double longitude;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<LatLng> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<LatLng> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LatLng createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new LatLng(parcel.readDouble(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LatLng[] newArray(int i) {
            return new LatLng[i];
        }
    }

    public LatLng() {
        this(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 3, null);
    }

    public static /* synthetic */ LatLng copy$default(LatLng latLng, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = latLng.latitude;
        }
        if ((i & 2) != 0) {
            d2 = latLng.longitude;
        }
        return latLng.copy(d, d2);
    }

    /* renamed from: component1  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    public final LatLng copy(double latitude, double longitude) {
        return new LatLng(latitude, longitude);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LatLng) {
            LatLng latLng = (LatLng) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(latLng.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(latLng.longitude));
        }
        return false;
    }

    public final int hashCode() {
        return (BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LatLng(latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }

    public LatLng(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public /* synthetic */ LatLng(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "setLatitude")
    public final void setLatitude(double d) {
        this.latitude = d;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "setLongitude")
    public final void setLongitude(double d) {
        this.longitude = d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LatLng(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto Lf
            java.lang.Double r5 = kotlin.text.StringsKt.toDoubleOrNull(r5)
            if (r5 == 0) goto Lf
            double r2 = r5.doubleValue()
            goto L10
        Lf:
            r2 = r0
        L10:
            if (r6 == 0) goto L1c
            java.lang.Double r5 = kotlin.text.StringsKt.toDoubleOrNull(r6)
            if (r5 == 0) goto L1c
            double r0 = r5.doubleValue()
        L1c:
            r4.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.globalsearch.model.LatLng.<init>(java.lang.String, java.lang.String):void");
    }

    @JvmName(name = "isUndefined")
    public final boolean isUndefined() {
        if (this.latitude == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return (this.longitude > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (this.longitude == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) == 0;
        }
        return false;
    }

    public final com.google.android.gms.maps.model.LatLng toGoogleLatLng() {
        return new com.google.android.gms.maps.model.LatLng(this.latitude, this.longitude);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/globalsearch/model/LatLng$Companion;", "", "Lid/dana/domain/globalsearch/model/LatLng;", "monas", "()Lid/dana/domain/globalsearch/model/LatLng;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LatLng monas() {
            return new LatLng(-6.17476d, 106.827072d);
        }
    }
}
