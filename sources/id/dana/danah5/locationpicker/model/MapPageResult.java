package id.dana.danah5.locationpicker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:Bg\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007Jt\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b$\u0010\u001eJ\u0010\u0010%\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b%\u0010\u0007J \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0015\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b.\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b/\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b3\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b4\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b5\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b6\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b7\u0010\u0007"}, d2 = {"Lid/dana/danah5/locationpicker/model/MapPageResult;", "Landroid/os/Parcelable;", "", "component1", "()D", "", "component10", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "latitude", "longitude", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "countryName", "provinceName", "cityName", "districtName", "subdistrictName", "streetName", "postalCode", "copy", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/danah5/locationpicker/model/MapPageResult;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCityName", "getCountryCode", "getCountryName", "getDistrictName", SummaryActivity.DAYS, "getLatitude", "getLongitude", "getPostalCode", "getProvinceName", "getStreetName", "getSubdistrictName", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MapPageResult implements Parcelable {
    private final String cityName;
    private final String countryCode;
    private final String countryName;
    private final String districtName;
    private final double latitude;
    private final double longitude;
    private final String postalCode;
    private final String provinceName;
    private final String streetName;
    private final String subdistrictName;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MapPageResult> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Creator implements Parcelable.Creator<MapPageResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapPageResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MapPageResult(parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapPageResult[] newArray(int i) {
            return new MapPageResult[i];
        }
    }

    @JvmStatic
    public static final MapPageResult monas() {
        return INSTANCE.monas();
    }

    /* renamed from: component1  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component10  reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getProvinceName() {
        return this.provinceName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    /* renamed from: component7  reason: from getter */
    public final String getDistrictName() {
        return this.districtName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSubdistrictName() {
        return this.subdistrictName;
    }

    /* renamed from: component9  reason: from getter */
    public final String getStreetName() {
        return this.streetName;
    }

    public final MapPageResult copy(double latitude, double longitude, String countryCode, String countryName, String provinceName, String cityName, String districtName, String subdistrictName, String streetName, String postalCode) {
        Intrinsics.checkNotNullParameter(countryCode, "");
        Intrinsics.checkNotNullParameter(countryName, "");
        Intrinsics.checkNotNullParameter(provinceName, "");
        Intrinsics.checkNotNullParameter(cityName, "");
        Intrinsics.checkNotNullParameter(districtName, "");
        Intrinsics.checkNotNullParameter(subdistrictName, "");
        Intrinsics.checkNotNullParameter(streetName, "");
        Intrinsics.checkNotNullParameter(postalCode, "");
        return new MapPageResult(latitude, longitude, countryCode, countryName, provinceName, cityName, districtName, subdistrictName, streetName, postalCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MapPageResult) {
            MapPageResult mapPageResult = (MapPageResult) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(mapPageResult.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(mapPageResult.longitude)) && Intrinsics.areEqual(this.countryCode, mapPageResult.countryCode) && Intrinsics.areEqual(this.countryName, mapPageResult.countryName) && Intrinsics.areEqual(this.provinceName, mapPageResult.provinceName) && Intrinsics.areEqual(this.cityName, mapPageResult.cityName) && Intrinsics.areEqual(this.districtName, mapPageResult.districtName) && Intrinsics.areEqual(this.subdistrictName, mapPageResult.subdistrictName) && Intrinsics.areEqual(this.streetName, mapPageResult.streetName) && Intrinsics.areEqual(this.postalCode, mapPageResult.postalCode);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude)) * 31) + this.countryCode.hashCode()) * 31) + this.countryName.hashCode()) * 31) + this.provinceName.hashCode()) * 31) + this.cityName.hashCode()) * 31) + this.districtName.hashCode()) * 31) + this.subdistrictName.hashCode()) * 31) + this.streetName.hashCode()) * 31) + this.postalCode.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MapPageResult(latitude=");
        sb.append(this.latitude);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", countryCode=");
        sb.append(this.countryCode);
        sb.append(", countryName=");
        sb.append(this.countryName);
        sb.append(", provinceName=");
        sb.append(this.provinceName);
        sb.append(", cityName=");
        sb.append(this.cityName);
        sb.append(", districtName=");
        sb.append(this.districtName);
        sb.append(", subdistrictName=");
        sb.append(this.subdistrictName);
        sb.append(", streetName=");
        sb.append(this.streetName);
        sb.append(", postalCode=");
        sb.append(this.postalCode);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.countryName);
        parcel.writeString(this.provinceName);
        parcel.writeString(this.cityName);
        parcel.writeString(this.districtName);
        parcel.writeString(this.subdistrictName);
        parcel.writeString(this.streetName);
        parcel.writeString(this.postalCode);
    }

    public MapPageResult(double d, double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.latitude = d;
        this.longitude = d2;
        this.countryCode = str;
        this.countryName = str2;
        this.provinceName = str3;
        this.cityName = str4;
        this.districtName = str5;
        this.subdistrictName = str6;
        this.streetName = str7;
        this.postalCode = str8;
    }

    public /* synthetic */ MapPageResult(double d, double d2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8);
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getCountryCode")
    public final String getCountryCode() {
        return this.countryCode;
    }

    @JvmName(name = "getCountryName")
    public final String getCountryName() {
        return this.countryName;
    }

    @JvmName(name = "getProvinceName")
    public final String getProvinceName() {
        return this.provinceName;
    }

    @JvmName(name = "getCityName")
    public final String getCityName() {
        return this.cityName;
    }

    @JvmName(name = "getDistrictName")
    public final String getDistrictName() {
        return this.districtName;
    }

    @JvmName(name = "getSubdistrictName")
    public final String getSubdistrictName() {
        return this.subdistrictName;
    }

    @JvmName(name = "getStreetName")
    public final String getStreetName() {
        return this.streetName;
    }

    @JvmName(name = "getPostalCode")
    public final String getPostalCode() {
        return this.postalCode;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danah5/locationpicker/model/MapPageResult$Companion;", "", "Lid/dana/danah5/locationpicker/model/MapPageResult;", "monas", "()Lid/dana/danah5/locationpicker/model/MapPageResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MapPageResult monas() {
            return new MapPageResult(LatLng.INSTANCE.monas().getLatitude(), LatLng.INSTANCE.monas().getLongitude(), "ID", "Indonesia", "Daerah Khusus Ibukota Jakarta", "Kota Jakarta Pusat", "Kecamatan Gambir", "Gambir", "Jalan Silang Merdeka", "10110");
        }
    }
}
