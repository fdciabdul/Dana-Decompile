package id.dana.domain.kycrenewal.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J~\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b/\u0010\u0004"}, d2 = {"Lid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "fullName", "gender", "certId", "dateOfBirth", "occupation", "address", "addressRT", "addressRW", "city", "district", "province", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/kycrenewal/model/KYCRenewalUserInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress", "getAddressRT", "getAddressRW", "getCertId", "getCity", "getDateOfBirth", "getDistrict", "getFullName", "getGender", "getOccupation", "getProvince", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class KYCRenewalUserInfo {
    private final String address;
    private final String addressRT;
    private final String addressRW;
    private final String certId;
    private final String city;
    private final String dateOfBirth;
    private final String district;
    private final String fullName;
    private final String gender;
    private final String occupation;
    private final String province;

    public KYCRenewalUserInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    /* renamed from: component11  reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCertId() {
        return this.certId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* renamed from: component5  reason: from getter */
    public final String getOccupation() {
        return this.occupation;
    }

    /* renamed from: component6  reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component7  reason: from getter */
    public final String getAddressRT() {
        return this.addressRT;
    }

    /* renamed from: component8  reason: from getter */
    public final String getAddressRW() {
        return this.addressRW;
    }

    /* renamed from: component9  reason: from getter */
    public final String getCity() {
        return this.city;
    }

    public final KYCRenewalUserInfo copy(String fullName, String gender, String certId, String dateOfBirth, String occupation, String address, String addressRT, String addressRW, String city, String district, String province) {
        Intrinsics.checkNotNullParameter(fullName, "");
        Intrinsics.checkNotNullParameter(gender, "");
        Intrinsics.checkNotNullParameter(certId, "");
        Intrinsics.checkNotNullParameter(dateOfBirth, "");
        Intrinsics.checkNotNullParameter(occupation, "");
        Intrinsics.checkNotNullParameter(address, "");
        Intrinsics.checkNotNullParameter(addressRT, "");
        Intrinsics.checkNotNullParameter(addressRW, "");
        Intrinsics.checkNotNullParameter(city, "");
        Intrinsics.checkNotNullParameter(district, "");
        Intrinsics.checkNotNullParameter(province, "");
        return new KYCRenewalUserInfo(fullName, gender, certId, dateOfBirth, occupation, address, addressRT, addressRW, city, district, province);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KYCRenewalUserInfo) {
            KYCRenewalUserInfo kYCRenewalUserInfo = (KYCRenewalUserInfo) other;
            return Intrinsics.areEqual(this.fullName, kYCRenewalUserInfo.fullName) && Intrinsics.areEqual(this.gender, kYCRenewalUserInfo.gender) && Intrinsics.areEqual(this.certId, kYCRenewalUserInfo.certId) && Intrinsics.areEqual(this.dateOfBirth, kYCRenewalUserInfo.dateOfBirth) && Intrinsics.areEqual(this.occupation, kYCRenewalUserInfo.occupation) && Intrinsics.areEqual(this.address, kYCRenewalUserInfo.address) && Intrinsics.areEqual(this.addressRT, kYCRenewalUserInfo.addressRT) && Intrinsics.areEqual(this.addressRW, kYCRenewalUserInfo.addressRW) && Intrinsics.areEqual(this.city, kYCRenewalUserInfo.city) && Intrinsics.areEqual(this.district, kYCRenewalUserInfo.district) && Intrinsics.areEqual(this.province, kYCRenewalUserInfo.province);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.fullName.hashCode() * 31) + this.gender.hashCode()) * 31) + this.certId.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.occupation.hashCode()) * 31) + this.address.hashCode()) * 31) + this.addressRT.hashCode()) * 31) + this.addressRW.hashCode()) * 31) + this.city.hashCode()) * 31) + this.district.hashCode()) * 31) + this.province.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KYCRenewalUserInfo(fullName=");
        sb.append(this.fullName);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", certId=");
        sb.append(this.certId);
        sb.append(", dateOfBirth=");
        sb.append(this.dateOfBirth);
        sb.append(", occupation=");
        sb.append(this.occupation);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", addressRT=");
        sb.append(this.addressRT);
        sb.append(", addressRW=");
        sb.append(this.addressRW);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", district=");
        sb.append(this.district);
        sb.append(", province=");
        sb.append(this.province);
        sb.append(')');
        return sb.toString();
    }

    public KYCRenewalUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        this.fullName = str;
        this.gender = str2;
        this.certId = str3;
        this.dateOfBirth = str4;
        this.occupation = str5;
        this.address = str6;
        this.addressRT = str7;
        this.addressRW = str8;
        this.city = str9;
        this.district = str10;
        this.province = str11;
    }

    public /* synthetic */ KYCRenewalUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) == 0 ? str11 : "");
    }

    @JvmName(name = "getFullName")
    public final String getFullName() {
        return this.fullName;
    }

    @JvmName(name = "getGender")
    public final String getGender() {
        return this.gender;
    }

    @JvmName(name = "getCertId")
    public final String getCertId() {
        return this.certId;
    }

    @JvmName(name = "getDateOfBirth")
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    @JvmName(name = "getOccupation")
    public final String getOccupation() {
        return this.occupation;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "getAddressRT")
    public final String getAddressRT() {
        return this.addressRT;
    }

    @JvmName(name = "getAddressRW")
    public final String getAddressRW() {
        return this.addressRW;
    }

    @JvmName(name = "getCity")
    public final String getCity() {
        return this.city;
    }

    @JvmName(name = "getDistrict")
    public final String getDistrict() {
        return this.district;
    }

    @JvmName(name = "getProvince")
    public final String getProvince() {
        return this.province;
    }
}
