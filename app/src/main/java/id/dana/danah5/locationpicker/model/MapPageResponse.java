package id.dana.danah5.locationpicker.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0092\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b.\u0010\tR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b2\u0010\u0004"}, d2 = {"Lid/dana/danah5/locationpicker/model/MapPageResponse;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component2", "()Ljava/lang/Double;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "choice", "lat", "long", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "countryName", "provinceName", "cityName", "districtName", "subdistrictName", "streetName", "postalCode", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/danah5/locationpicker/model/MapPageResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getChoice", "getCityName", "getCountryCode", "getCountryName", "getDistrictName", "Ljava/lang/Double;", "getLat", "getLong", "getPostalCode", "getProvinceName", "getStreetName", "getSubdistrictName", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class MapPageResponse {
    private final String choice;
    private final String cityName;
    private final String countryCode;
    private final String countryName;
    private final String districtName;
    private final Double lat;
    private final Double long;
    private final String postalCode;
    private final String provinceName;
    private final String streetName;
    private final String subdistrictName;

    public MapPageResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getChoice() {
        return this.choice;
    }

    /* renamed from: component10  reason: from getter */
    public final String getStreetName() {
        return this.streetName;
    }

    /* renamed from: component11  reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component2  reason: from getter */
    public final Double getLat() {
        return this.lat;
    }

    /* renamed from: component3  reason: from getter */
    public final Double getLong() {
        return this.long;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getProvinceName() {
        return this.provinceName;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getDistrictName() {
        return this.districtName;
    }

    /* renamed from: component9  reason: from getter */
    public final String getSubdistrictName() {
        return this.subdistrictName;
    }

    public final MapPageResponse copy(String choice, Double lat, Double r16, String countryCode, String countryName, String provinceName, String cityName, String districtName, String subdistrictName, String streetName, String postalCode) {
        Intrinsics.checkNotNullParameter(choice, "");
        return new MapPageResponse(choice, lat, r16, countryCode, countryName, provinceName, cityName, districtName, subdistrictName, streetName, postalCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MapPageResponse) {
            MapPageResponse mapPageResponse = (MapPageResponse) other;
            return Intrinsics.areEqual(this.choice, mapPageResponse.choice) && Intrinsics.areEqual((Object) this.lat, (Object) mapPageResponse.lat) && Intrinsics.areEqual((Object) this.long, (Object) mapPageResponse.long) && Intrinsics.areEqual(this.countryCode, mapPageResponse.countryCode) && Intrinsics.areEqual(this.countryName, mapPageResponse.countryName) && Intrinsics.areEqual(this.provinceName, mapPageResponse.provinceName) && Intrinsics.areEqual(this.cityName, mapPageResponse.cityName) && Intrinsics.areEqual(this.districtName, mapPageResponse.districtName) && Intrinsics.areEqual(this.subdistrictName, mapPageResponse.subdistrictName) && Intrinsics.areEqual(this.streetName, mapPageResponse.streetName) && Intrinsics.areEqual(this.postalCode, mapPageResponse.postalCode);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.choice.hashCode();
        Double d = this.lat;
        int hashCode2 = d == null ? 0 : d.hashCode();
        Double d2 = this.long;
        int hashCode3 = d2 == null ? 0 : d2.hashCode();
        String str = this.countryCode;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.countryName;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.provinceName;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cityName;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.districtName;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.subdistrictName;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.streetName;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.postalCode;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MapPageResponse(choice=");
        sb.append(this.choice);
        sb.append(", lat=");
        sb.append(this.lat);
        sb.append(", long=");
        sb.append(this.long);
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

    public MapPageResponse(String str, Double d, Double d2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        this.choice = str;
        this.lat = d;
        this.long = d2;
        this.countryCode = str2;
        this.countryName = str3;
        this.provinceName = str4;
        this.cityName = str5;
        this.districtName = str6;
        this.subdistrictName = str7;
        this.streetName = str8;
        this.postalCode = str9;
    }

    public /* synthetic */ MapPageResponse(String str, Double d, Double d2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "CANCEL" : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) == 0 ? str9 : null);
    }

    @JvmName(name = "getChoice")
    public final String getChoice() {
        return this.choice;
    }

    @JvmName(name = "getLat")
    public final Double getLat() {
        return this.lat;
    }

    @JvmName(name = "getLong")
    public final Double getLong() {
        return this.long;
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
}
