package id.dana.kyb.data.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J¬\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b5\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/KybInfoResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "RESIDENTIAL_ADDRESS", "USER_ID", "OPERATION_HOURS", "BUSINESS_ADDRESS", "PRODUCTID", "BUSINESS_NAME", "OWNER_NAME", "OUTLET_PHOTO_URL", "OWNER_TAX_NUMBER", "BUSSINESS_CITY", "BUSINESS_TYPE", "POSTAL_CODE", "LOGO_URL", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/data/model/KybInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBUSINESS_ADDRESS", "getBUSINESS_NAME", "getBUSINESS_TYPE", "getBUSSINESS_CITY", "getLOGO_URL", "getOPERATION_HOURS", "getOUTLET_PHOTO_URL", "getOWNER_NAME", "getOWNER_TAX_NUMBER", "getPOSTAL_CODE", "getPRODUCTID", "getRESIDENTIAL_ADDRESS", "getUSER_ID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybInfoResult {
    public String BUSINESS_ADDRESS;
    public String BUSINESS_NAME;
    public String BUSINESS_TYPE;
    public String BUSSINESS_CITY;
    public String LOGO_URL;
    public String OPERATION_HOURS;
    public String OUTLET_PHOTO_URL;
    public String OWNER_NAME;
    public String OWNER_TAX_NUMBER;
    public String POSTAL_CODE;
    public String PRODUCTID;
    public String RESIDENTIAL_ADDRESS;
    public String USER_ID;

    public KybInfoResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRESIDENTIAL_ADDRESS() {
        return this.RESIDENTIAL_ADDRESS;
    }

    /* renamed from: component10  reason: from getter */
    public final String getBUSSINESS_CITY() {
        return this.BUSSINESS_CITY;
    }

    /* renamed from: component11  reason: from getter */
    public final String getBUSINESS_TYPE() {
        return this.BUSINESS_TYPE;
    }

    /* renamed from: component12  reason: from getter */
    public final String getPOSTAL_CODE() {
        return this.POSTAL_CODE;
    }

    /* renamed from: component13  reason: from getter */
    public final String getLOGO_URL() {
        return this.LOGO_URL;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUSER_ID() {
        return this.USER_ID;
    }

    /* renamed from: component3  reason: from getter */
    public final String getOPERATION_HOURS() {
        return this.OPERATION_HOURS;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBUSINESS_ADDRESS() {
        return this.BUSINESS_ADDRESS;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPRODUCTID() {
        return this.PRODUCTID;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBUSINESS_NAME() {
        return this.BUSINESS_NAME;
    }

    /* renamed from: component7  reason: from getter */
    public final String getOWNER_NAME() {
        return this.OWNER_NAME;
    }

    /* renamed from: component8  reason: from getter */
    public final String getOUTLET_PHOTO_URL() {
        return this.OUTLET_PHOTO_URL;
    }

    /* renamed from: component9  reason: from getter */
    public final String getOWNER_TAX_NUMBER() {
        return this.OWNER_TAX_NUMBER;
    }

    public final KybInfoResult copy(String RESIDENTIAL_ADDRESS, String USER_ID, String OPERATION_HOURS, String BUSINESS_ADDRESS, String PRODUCTID, String BUSINESS_NAME, String OWNER_NAME, String OUTLET_PHOTO_URL, String OWNER_TAX_NUMBER, String BUSSINESS_CITY, String BUSINESS_TYPE, String POSTAL_CODE, String LOGO_URL) {
        return new KybInfoResult(RESIDENTIAL_ADDRESS, USER_ID, OPERATION_HOURS, BUSINESS_ADDRESS, PRODUCTID, BUSINESS_NAME, OWNER_NAME, OUTLET_PHOTO_URL, OWNER_TAX_NUMBER, BUSSINESS_CITY, BUSINESS_TYPE, POSTAL_CODE, LOGO_URL);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybInfoResult) {
            KybInfoResult kybInfoResult = (KybInfoResult) other;
            return Intrinsics.areEqual(this.RESIDENTIAL_ADDRESS, kybInfoResult.RESIDENTIAL_ADDRESS) && Intrinsics.areEqual(this.USER_ID, kybInfoResult.USER_ID) && Intrinsics.areEqual(this.OPERATION_HOURS, kybInfoResult.OPERATION_HOURS) && Intrinsics.areEqual(this.BUSINESS_ADDRESS, kybInfoResult.BUSINESS_ADDRESS) && Intrinsics.areEqual(this.PRODUCTID, kybInfoResult.PRODUCTID) && Intrinsics.areEqual(this.BUSINESS_NAME, kybInfoResult.BUSINESS_NAME) && Intrinsics.areEqual(this.OWNER_NAME, kybInfoResult.OWNER_NAME) && Intrinsics.areEqual(this.OUTLET_PHOTO_URL, kybInfoResult.OUTLET_PHOTO_URL) && Intrinsics.areEqual(this.OWNER_TAX_NUMBER, kybInfoResult.OWNER_TAX_NUMBER) && Intrinsics.areEqual(this.BUSSINESS_CITY, kybInfoResult.BUSSINESS_CITY) && Intrinsics.areEqual(this.BUSINESS_TYPE, kybInfoResult.BUSINESS_TYPE) && Intrinsics.areEqual(this.POSTAL_CODE, kybInfoResult.POSTAL_CODE) && Intrinsics.areEqual(this.LOGO_URL, kybInfoResult.LOGO_URL);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.RESIDENTIAL_ADDRESS;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.USER_ID;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.OPERATION_HOURS;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BUSINESS_ADDRESS;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.PRODUCTID;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.BUSINESS_NAME;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.OWNER_NAME;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.OUTLET_PHOTO_URL;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.OWNER_TAX_NUMBER;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.BUSSINESS_CITY;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.BUSINESS_TYPE;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.POSTAL_CODE;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.LOGO_URL;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str13 != null ? str13.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybInfoResult(RESIDENTIAL_ADDRESS=");
        sb.append(this.RESIDENTIAL_ADDRESS);
        sb.append(", USER_ID=");
        sb.append(this.USER_ID);
        sb.append(", OPERATION_HOURS=");
        sb.append(this.OPERATION_HOURS);
        sb.append(", BUSINESS_ADDRESS=");
        sb.append(this.BUSINESS_ADDRESS);
        sb.append(", PRODUCTID=");
        sb.append(this.PRODUCTID);
        sb.append(", BUSINESS_NAME=");
        sb.append(this.BUSINESS_NAME);
        sb.append(", OWNER_NAME=");
        sb.append(this.OWNER_NAME);
        sb.append(", OUTLET_PHOTO_URL=");
        sb.append(this.OUTLET_PHOTO_URL);
        sb.append(", OWNER_TAX_NUMBER=");
        sb.append(this.OWNER_TAX_NUMBER);
        sb.append(", BUSSINESS_CITY=");
        sb.append(this.BUSSINESS_CITY);
        sb.append(", BUSINESS_TYPE=");
        sb.append(this.BUSINESS_TYPE);
        sb.append(", POSTAL_CODE=");
        sb.append(this.POSTAL_CODE);
        sb.append(", LOGO_URL=");
        sb.append(this.LOGO_URL);
        sb.append(')');
        return sb.toString();
    }

    public KybInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.RESIDENTIAL_ADDRESS = str;
        this.USER_ID = str2;
        this.OPERATION_HOURS = str3;
        this.BUSINESS_ADDRESS = str4;
        this.PRODUCTID = str5;
        this.BUSINESS_NAME = str6;
        this.OWNER_NAME = str7;
        this.OUTLET_PHOTO_URL = str8;
        this.OWNER_TAX_NUMBER = str9;
        this.BUSSINESS_CITY = str10;
        this.BUSINESS_TYPE = str11;
        this.POSTAL_CODE = str12;
        this.LOGO_URL = str13;
    }

    public /* synthetic */ KybInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) == 0 ? str13 : null);
    }

    @JvmName(name = "getRESIDENTIAL_ADDRESS")
    public final String getRESIDENTIAL_ADDRESS() {
        return this.RESIDENTIAL_ADDRESS;
    }

    @JvmName(name = "getUSER_ID")
    public final String getUSER_ID() {
        return this.USER_ID;
    }

    @JvmName(name = "getOPERATION_HOURS")
    public final String getOPERATION_HOURS() {
        return this.OPERATION_HOURS;
    }

    @JvmName(name = "getBUSINESS_ADDRESS")
    public final String getBUSINESS_ADDRESS() {
        return this.BUSINESS_ADDRESS;
    }

    @JvmName(name = "getPRODUCTID")
    public final String getPRODUCTID() {
        return this.PRODUCTID;
    }

    @JvmName(name = "getBUSINESS_NAME")
    public final String getBUSINESS_NAME() {
        return this.BUSINESS_NAME;
    }

    @JvmName(name = "getOWNER_NAME")
    public final String getOWNER_NAME() {
        return this.OWNER_NAME;
    }

    @JvmName(name = "getOUTLET_PHOTO_URL")
    public final String getOUTLET_PHOTO_URL() {
        return this.OUTLET_PHOTO_URL;
    }

    @JvmName(name = "getOWNER_TAX_NUMBER")
    public final String getOWNER_TAX_NUMBER() {
        return this.OWNER_TAX_NUMBER;
    }

    @JvmName(name = "getBUSSINESS_CITY")
    public final String getBUSSINESS_CITY() {
        return this.BUSSINESS_CITY;
    }

    @JvmName(name = "getBUSINESS_TYPE")
    public final String getBUSINESS_TYPE() {
        return this.BUSINESS_TYPE;
    }

    @JvmName(name = "getPOSTAL_CODE")
    public final String getPOSTAL_CODE() {
        return this.POSTAL_CODE;
    }

    @JvmName(name = "getLOGO_URL")
    public final String getLOGO_URL() {
        return this.LOGO_URL;
    }
}
