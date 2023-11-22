package id.dana.data.here.model;

import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b/\u00100J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0088\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b.\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/Address;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.ScionAnalytics.PARAM_LABEL, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "countryName", "state", "county", "city", "district", "subdistrict", "street", "postalCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/data/here/model/Address;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCity", "getCountryCode", "getCountryName", "getCounty", "getDistrict", "getLabel", "Ljava/lang/Integer;", "getPostalCode", "getState", "getStreet", "getSubdistrict", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Address {
    @SerializedName("city")
    private final String city;
    @SerializedName(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE)
    private final String countryCode;
    @SerializedName("countryName")
    private final String countryName;
    @SerializedName("county")
    private final String county;
    @SerializedName("district")
    private final String district;
    @SerializedName(Constants.ScionAnalytics.PARAM_LABEL)
    private final String label;
    @SerializedName("postalCode")
    private final Integer postalCode;
    @SerializedName("state")
    private final String state;
    @SerializedName("street")
    private final String street;
    @SerializedName("subdistrict")
    private final String subdistrict;

    public Address() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component10  reason: from getter */
    public final Integer getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCounty() {
        return this.county;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component7  reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSubdistrict() {
        return this.subdistrict;
    }

    /* renamed from: component9  reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    public final Address copy(String label, String countryCode, String countryName, String state, String county, String city, String district, String subdistrict, String street, Integer postalCode) {
        return new Address(label, countryCode, countryName, state, county, city, district, subdistrict, street, postalCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Address) {
            Address address = (Address) other;
            return Intrinsics.areEqual(this.label, address.label) && Intrinsics.areEqual(this.countryCode, address.countryCode) && Intrinsics.areEqual(this.countryName, address.countryName) && Intrinsics.areEqual(this.state, address.state) && Intrinsics.areEqual(this.county, address.county) && Intrinsics.areEqual(this.city, address.city) && Intrinsics.areEqual(this.district, address.district) && Intrinsics.areEqual(this.subdistrict, address.subdistrict) && Intrinsics.areEqual(this.street, address.street) && Intrinsics.areEqual(this.postalCode, address.postalCode);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.label;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.countryCode;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.countryName;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.state;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.county;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.city;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.district;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.subdistrict;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.street;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        Integer num = this.postalCode;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address(label=");
        sb.append(this.label);
        sb.append(", countryCode=");
        sb.append(this.countryCode);
        sb.append(", countryName=");
        sb.append(this.countryName);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", county=");
        sb.append(this.county);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", district=");
        sb.append(this.district);
        sb.append(", subdistrict=");
        sb.append(this.subdistrict);
        sb.append(", street=");
        sb.append(this.street);
        sb.append(", postalCode=");
        sb.append(this.postalCode);
        sb.append(')');
        return sb.toString();
    }

    public Address(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num) {
        this.label = str;
        this.countryCode = str2;
        this.countryName = str3;
        this.state = str4;
        this.county = str5;
        this.city = str6;
        this.district = str7;
        this.subdistrict = str8;
        this.street = str9;
        this.postalCode = num;
    }

    @JvmName(name = "getLabel")
    public final String getLabel() {
        return this.label;
    }

    @JvmName(name = "getCountryCode")
    public final String getCountryCode() {
        return this.countryCode;
    }

    @JvmName(name = "getCountryName")
    public final String getCountryName() {
        return this.countryName;
    }

    @JvmName(name = "getState")
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "getCounty")
    public final String getCounty() {
        return this.county;
    }

    @JvmName(name = "getCity")
    public final String getCity() {
        return this.city;
    }

    @JvmName(name = "getDistrict")
    public final String getDistrict() {
        return this.district;
    }

    @JvmName(name = "getSubdistrict")
    public final String getSubdistrict() {
        return this.subdistrict;
    }

    @JvmName(name = "getStreet")
    public final String getStreet() {
        return this.street;
    }

    public /* synthetic */ Address(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) == 0 ? str9 : "", (i & 512) != 0 ? 0 : num);
    }

    @JvmName(name = "getPostalCode")
    public final Integer getPostalCode() {
        return this.postalCode;
    }
}
