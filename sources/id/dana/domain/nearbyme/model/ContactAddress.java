package id.dana.domain.nearbyme.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u009c\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010*R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010*R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010*R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010*R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010*R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010*R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u0010*R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010'\u001a\u0004\b7\u0010\u0004\"\u0004\b8\u0010*R\"\u0010\u0019\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00109\u001a\u0004\b\u0019\u0010\b\"\u0004\b:\u0010;R\"\u0010\u001c\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00109\u001a\u0004\b\u001c\u0010\b\"\u0004\b<\u0010;R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010'\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u0010*R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010*"}, d2 = {"Lid/dana/domain/nearbyme/model/ContactAddress;", "", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Z", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "address1", "address2", "area", "city", "contactAddressId", "contactAddressType", GeocoderResultMapperKt.COUNTRY, "isDefaultAddress", "extendInfo", "province", "isVerified", "zipcode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lid/dana/domain/nearbyme/model/ContactAddress;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress1", "setAddress1", "(Ljava/lang/String;)V", "getAddress2", "setAddress2", "getArea", "setArea", "getCity", "setCity", "getContactAddressId", "setContactAddressId", "getContactAddressType", "setContactAddressType", "getCountry", "setCountry", "getExtendInfo", "setExtendInfo", "Z", "setDefaultAddress", "(Z)V", "setVerified", "getProvince", "setProvince", "getZipcode", "setZipcode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ContactAddress {
    private String address1;
    private String address2;
    private String area;
    private String city;
    private String contactAddressId;
    private String contactAddressType;
    private String country;
    private String extendInfo;
    private boolean isDefaultAddress;
    private boolean isVerified;
    private String province;
    private String zipcode;

    public ContactAddress() {
        this(null, null, null, null, null, null, null, false, null, null, false, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAddress1() {
        return this.address1;
    }

    /* renamed from: component10  reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* renamed from: component11  reason: from getter */
    public final boolean getIsVerified() {
        return this.isVerified;
    }

    /* renamed from: component12  reason: from getter */
    public final String getZipcode() {
        return this.zipcode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAddress2() {
        return this.address2;
    }

    /* renamed from: component3  reason: from getter */
    public final String getArea() {
        return this.area;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component5  reason: from getter */
    public final String getContactAddressId() {
        return this.contactAddressId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getContactAddressType() {
        return this.contactAddressType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getIsDefaultAddress() {
        return this.isDefaultAddress;
    }

    /* renamed from: component9  reason: from getter */
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    public final ContactAddress copy(String address1, String address2, String area, String city, String contactAddressId, String contactAddressType, String country, boolean isDefaultAddress, String extendInfo, String province, boolean isVerified, String zipcode) {
        return new ContactAddress(address1, address2, area, city, contactAddressId, contactAddressType, country, isDefaultAddress, extendInfo, province, isVerified, zipcode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ContactAddress) {
            ContactAddress contactAddress = (ContactAddress) other;
            return Intrinsics.areEqual(this.address1, contactAddress.address1) && Intrinsics.areEqual(this.address2, contactAddress.address2) && Intrinsics.areEqual(this.area, contactAddress.area) && Intrinsics.areEqual(this.city, contactAddress.city) && Intrinsics.areEqual(this.contactAddressId, contactAddress.contactAddressId) && Intrinsics.areEqual(this.contactAddressType, contactAddress.contactAddressType) && Intrinsics.areEqual(this.country, contactAddress.country) && this.isDefaultAddress == contactAddress.isDefaultAddress && Intrinsics.areEqual(this.extendInfo, contactAddress.extendInfo) && Intrinsics.areEqual(this.province, contactAddress.province) && this.isVerified == contactAddress.isVerified && Intrinsics.areEqual(this.zipcode, contactAddress.zipcode);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.address1;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.address2;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.area;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.city;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.contactAddressId;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.contactAddressType;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.country;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.isDefaultAddress;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str8 = this.extendInfo;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.province;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        boolean z2 = this.isVerified;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        String str10 = this.zipcode;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i) * 31) + hashCode8) * 31) + hashCode9) * 31) + i2) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactAddress(address1=");
        sb.append(this.address1);
        sb.append(", address2=");
        sb.append(this.address2);
        sb.append(", area=");
        sb.append(this.area);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", contactAddressId=");
        sb.append(this.contactAddressId);
        sb.append(", contactAddressType=");
        sb.append(this.contactAddressType);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", isDefaultAddress=");
        sb.append(this.isDefaultAddress);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", province=");
        sb.append(this.province);
        sb.append(", isVerified=");
        sb.append(this.isVerified);
        sb.append(", zipcode=");
        sb.append(this.zipcode);
        sb.append(')');
        return sb.toString();
    }

    public ContactAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, String str9, boolean z2, String str10) {
        this.address1 = str;
        this.address2 = str2;
        this.area = str3;
        this.city = str4;
        this.contactAddressId = str5;
        this.contactAddressType = str6;
        this.country = str7;
        this.isDefaultAddress = z;
        this.extendInfo = str8;
        this.province = str9;
        this.isVerified = z2;
        this.zipcode = str10;
    }

    public /* synthetic */ ContactAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, String str9, boolean z2, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? false : z, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) == 0 ? z2 : false, (i & 2048) == 0 ? str10 : "");
    }

    @JvmName(name = "getAddress1")
    public final String getAddress1() {
        return this.address1;
    }

    @JvmName(name = "setAddress1")
    public final void setAddress1(String str) {
        this.address1 = str;
    }

    @JvmName(name = "getAddress2")
    public final String getAddress2() {
        return this.address2;
    }

    @JvmName(name = "setAddress2")
    public final void setAddress2(String str) {
        this.address2 = str;
    }

    @JvmName(name = "getArea")
    public final String getArea() {
        return this.area;
    }

    @JvmName(name = "setArea")
    public final void setArea(String str) {
        this.area = str;
    }

    @JvmName(name = "getCity")
    public final String getCity() {
        return this.city;
    }

    @JvmName(name = "setCity")
    public final void setCity(String str) {
        this.city = str;
    }

    @JvmName(name = "getContactAddressId")
    public final String getContactAddressId() {
        return this.contactAddressId;
    }

    @JvmName(name = "setContactAddressId")
    public final void setContactAddressId(String str) {
        this.contactAddressId = str;
    }

    @JvmName(name = "getContactAddressType")
    public final String getContactAddressType() {
        return this.contactAddressType;
    }

    @JvmName(name = "setContactAddressType")
    public final void setContactAddressType(String str) {
        this.contactAddressType = str;
    }

    @JvmName(name = "getCountry")
    public final String getCountry() {
        return this.country;
    }

    @JvmName(name = "setCountry")
    public final void setCountry(String str) {
        this.country = str;
    }

    @JvmName(name = "isDefaultAddress")
    public final boolean isDefaultAddress() {
        return this.isDefaultAddress;
    }

    @JvmName(name = "setDefaultAddress")
    public final void setDefaultAddress(boolean z) {
        this.isDefaultAddress = z;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    @JvmName(name = "getProvince")
    public final String getProvince() {
        return this.province;
    }

    @JvmName(name = "setProvince")
    public final void setProvince(String str) {
        this.province = str;
    }

    @JvmName(name = "isVerified")
    public final boolean isVerified() {
        return this.isVerified;
    }

    @JvmName(name = "setVerified")
    public final void setVerified(boolean z) {
        this.isVerified = z;
    }

    @JvmName(name = "getZipcode")
    public final String getZipcode() {
        return this.zipcode;
    }

    @JvmName(name = "setZipcode")
    public final void setZipcode(String str) {
        this.zipcode = str;
    }
}
