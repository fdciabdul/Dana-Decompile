package id.dana.kyb.domain.model;

import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J¬\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b5\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/KybInfo;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "residentialAddress", "userId", "operationHours", "businessAddress", "productId", "businessName", "ownerName", "outletPhotoUrl", "ownerTaxNumber", "businessCity", "businessType", "postalCode", DecodedScanBizInfoKey.LOGO_URL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/domain/model/KybInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBusinessAddress", "getBusinessCity", "getBusinessName", "getBusinessType", "getLogoUrl", "getOperationHours", "getOutletPhotoUrl", "getOwnerName", "getOwnerTaxNumber", "getPostalCode", "getProductId", "getResidentialAddress", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybInfo {
    private final String businessAddress;
    private final String businessCity;
    private final String businessName;
    private final String businessType;
    private final String logoUrl;
    private final String operationHours;
    private final String outletPhotoUrl;
    private final String ownerName;
    private final String ownerTaxNumber;
    private final String postalCode;
    private final String productId;
    private final String residentialAddress;
    private final String userId;

    public KybInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResidentialAddress() {
        return this.residentialAddress;
    }

    /* renamed from: component10  reason: from getter */
    public final String getBusinessCity() {
        return this.businessCity;
    }

    /* renamed from: component11  reason: from getter */
    public final String getBusinessType() {
        return this.businessType;
    }

    /* renamed from: component12  reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component13  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOperationHours() {
        return this.operationHours;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBusinessAddress() {
        return this.businessAddress;
    }

    /* renamed from: component5  reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBusinessName() {
        return this.businessName;
    }

    /* renamed from: component7  reason: from getter */
    public final String getOwnerName() {
        return this.ownerName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getOutletPhotoUrl() {
        return this.outletPhotoUrl;
    }

    /* renamed from: component9  reason: from getter */
    public final String getOwnerTaxNumber() {
        return this.ownerTaxNumber;
    }

    public final KybInfo copy(String residentialAddress, String userId, String operationHours, String businessAddress, String productId, String businessName, String ownerName, String outletPhotoUrl, String ownerTaxNumber, String businessCity, String businessType, String postalCode, String logoUrl) {
        return new KybInfo(residentialAddress, userId, operationHours, businessAddress, productId, businessName, ownerName, outletPhotoUrl, ownerTaxNumber, businessCity, businessType, postalCode, logoUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybInfo) {
            KybInfo kybInfo = (KybInfo) other;
            return Intrinsics.areEqual(this.residentialAddress, kybInfo.residentialAddress) && Intrinsics.areEqual(this.userId, kybInfo.userId) && Intrinsics.areEqual(this.operationHours, kybInfo.operationHours) && Intrinsics.areEqual(this.businessAddress, kybInfo.businessAddress) && Intrinsics.areEqual(this.productId, kybInfo.productId) && Intrinsics.areEqual(this.businessName, kybInfo.businessName) && Intrinsics.areEqual(this.ownerName, kybInfo.ownerName) && Intrinsics.areEqual(this.outletPhotoUrl, kybInfo.outletPhotoUrl) && Intrinsics.areEqual(this.ownerTaxNumber, kybInfo.ownerTaxNumber) && Intrinsics.areEqual(this.businessCity, kybInfo.businessCity) && Intrinsics.areEqual(this.businessType, kybInfo.businessType) && Intrinsics.areEqual(this.postalCode, kybInfo.postalCode) && Intrinsics.areEqual(this.logoUrl, kybInfo.logoUrl);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.residentialAddress;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.userId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.operationHours;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.businessAddress;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.productId;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.businessName;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.ownerName;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.outletPhotoUrl;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.ownerTaxNumber;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.businessCity;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.businessType;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.postalCode;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.logoUrl;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str13 != null ? str13.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybInfo(residentialAddress=");
        sb.append(this.residentialAddress);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", operationHours=");
        sb.append(this.operationHours);
        sb.append(", businessAddress=");
        sb.append(this.businessAddress);
        sb.append(", productId=");
        sb.append(this.productId);
        sb.append(", businessName=");
        sb.append(this.businessName);
        sb.append(", ownerName=");
        sb.append(this.ownerName);
        sb.append(", outletPhotoUrl=");
        sb.append(this.outletPhotoUrl);
        sb.append(", ownerTaxNumber=");
        sb.append(this.ownerTaxNumber);
        sb.append(", businessCity=");
        sb.append(this.businessCity);
        sb.append(", businessType=");
        sb.append(this.businessType);
        sb.append(", postalCode=");
        sb.append(this.postalCode);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(')');
        return sb.toString();
    }

    public KybInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.residentialAddress = str;
        this.userId = str2;
        this.operationHours = str3;
        this.businessAddress = str4;
        this.productId = str5;
        this.businessName = str6;
        this.ownerName = str7;
        this.outletPhotoUrl = str8;
        this.ownerTaxNumber = str9;
        this.businessCity = str10;
        this.businessType = str11;
        this.postalCode = str12;
        this.logoUrl = str13;
    }

    public /* synthetic */ KybInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) == 0 ? str13 : null);
    }

    @JvmName(name = "getResidentialAddress")
    public final String getResidentialAddress() {
        return this.residentialAddress;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getOperationHours")
    public final String getOperationHours() {
        return this.operationHours;
    }

    @JvmName(name = "getBusinessAddress")
    public final String getBusinessAddress() {
        return this.businessAddress;
    }

    @JvmName(name = "getProductId")
    public final String getProductId() {
        return this.productId;
    }

    @JvmName(name = "getBusinessName")
    public final String getBusinessName() {
        return this.businessName;
    }

    @JvmName(name = "getOwnerName")
    public final String getOwnerName() {
        return this.ownerName;
    }

    @JvmName(name = "getOutletPhotoUrl")
    public final String getOutletPhotoUrl() {
        return this.outletPhotoUrl;
    }

    @JvmName(name = "getOwnerTaxNumber")
    public final String getOwnerTaxNumber() {
        return this.ownerTaxNumber;
    }

    @JvmName(name = "getBusinessCity")
    public final String getBusinessCity() {
        return this.businessCity;
    }

    @JvmName(name = "getBusinessType")
    public final String getBusinessType() {
        return this.businessType;
    }

    @JvmName(name = "getPostalCode")
    public final String getPostalCode() {
        return this.postalCode;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }
}
