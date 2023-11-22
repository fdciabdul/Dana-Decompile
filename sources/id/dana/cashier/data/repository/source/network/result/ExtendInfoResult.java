package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b5\u00106J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J \u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b4\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component12", "()Ljava/lang/Boolean;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "bankMobilePhoneNo", "bankToken", "cardBin", "cardCacheToken", "dailyLimit", "bizProcessId", "cardScheme", "ektp", "interbankSupport", "headerDescription", "serviceInstID", "needRegistration", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankMobilePhoneNo", "getBankToken", "getBizProcessId", "getCardBin", "getCardCacheToken", "getCardScheme", "getDailyLimit", "getEktp", "getHeaderDescription", "getInterbankSupport", "Ljava/lang/Boolean;", "getNeedRegistration", "getServiceInstID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ExtendInfoResult {
    @SerializedName("bankMobilePhoneNo")
    private final String bankMobilePhoneNo;
    private final String bankToken;
    private final String bizProcessId;
    private final String cardBin;
    private final String cardCacheToken;
    private final String cardScheme;
    private final String dailyLimit;
    private final String ektp;
    private final String headerDescription;
    private final String interbankSupport;
    private final Boolean needRegistration;
    private final String serviceInstID;

    /* renamed from: component1  reason: from getter */
    public final String getBankMobilePhoneNo() {
        return this.bankMobilePhoneNo;
    }

    /* renamed from: component10  reason: from getter */
    public final String getHeaderDescription() {
        return this.headerDescription;
    }

    /* renamed from: component11  reason: from getter */
    public final String getServiceInstID() {
        return this.serviceInstID;
    }

    /* renamed from: component12  reason: from getter */
    public final Boolean getNeedRegistration() {
        return this.needRegistration;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBankToken() {
        return this.bankToken;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCardBin() {
        return this.cardBin;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCardCacheToken() {
        return this.cardCacheToken;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDailyLimit() {
        return this.dailyLimit;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBizProcessId() {
        return this.bizProcessId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCardScheme() {
        return this.cardScheme;
    }

    /* renamed from: component8  reason: from getter */
    public final String getEktp() {
        return this.ektp;
    }

    /* renamed from: component9  reason: from getter */
    public final String getInterbankSupport() {
        return this.interbankSupport;
    }

    public final ExtendInfoResult copy(String bankMobilePhoneNo, String bankToken, String cardBin, String cardCacheToken, String dailyLimit, String bizProcessId, String cardScheme, String ektp, String interbankSupport, String headerDescription, String serviceInstID, Boolean needRegistration) {
        return new ExtendInfoResult(bankMobilePhoneNo, bankToken, cardBin, cardCacheToken, dailyLimit, bizProcessId, cardScheme, ektp, interbankSupport, headerDescription, serviceInstID, needRegistration);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExtendInfoResult) {
            ExtendInfoResult extendInfoResult = (ExtendInfoResult) other;
            return Intrinsics.areEqual(this.bankMobilePhoneNo, extendInfoResult.bankMobilePhoneNo) && Intrinsics.areEqual(this.bankToken, extendInfoResult.bankToken) && Intrinsics.areEqual(this.cardBin, extendInfoResult.cardBin) && Intrinsics.areEqual(this.cardCacheToken, extendInfoResult.cardCacheToken) && Intrinsics.areEqual(this.dailyLimit, extendInfoResult.dailyLimit) && Intrinsics.areEqual(this.bizProcessId, extendInfoResult.bizProcessId) && Intrinsics.areEqual(this.cardScheme, extendInfoResult.cardScheme) && Intrinsics.areEqual(this.ektp, extendInfoResult.ektp) && Intrinsics.areEqual(this.interbankSupport, extendInfoResult.interbankSupport) && Intrinsics.areEqual(this.headerDescription, extendInfoResult.headerDescription) && Intrinsics.areEqual(this.serviceInstID, extendInfoResult.serviceInstID) && Intrinsics.areEqual(this.needRegistration, extendInfoResult.needRegistration);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bankMobilePhoneNo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bankToken;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.cardBin;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cardCacheToken;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.dailyLimit;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.bizProcessId;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.cardScheme;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.ektp;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.interbankSupport;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.headerDescription;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.serviceInstID;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        Boolean bool = this.needRegistration;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtendInfoResult(bankMobilePhoneNo=");
        sb.append(this.bankMobilePhoneNo);
        sb.append(", bankToken=");
        sb.append(this.bankToken);
        sb.append(", cardBin=");
        sb.append(this.cardBin);
        sb.append(", cardCacheToken=");
        sb.append(this.cardCacheToken);
        sb.append(", dailyLimit=");
        sb.append(this.dailyLimit);
        sb.append(", bizProcessId=");
        sb.append(this.bizProcessId);
        sb.append(", cardScheme=");
        sb.append(this.cardScheme);
        sb.append(", ektp=");
        sb.append(this.ektp);
        sb.append(", interbankSupport=");
        sb.append(this.interbankSupport);
        sb.append(", headerDescription=");
        sb.append(this.headerDescription);
        sb.append(", serviceInstID=");
        sb.append(this.serviceInstID);
        sb.append(", needRegistration=");
        sb.append(this.needRegistration);
        sb.append(')');
        return sb.toString();
    }

    public ExtendInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool) {
        this.bankMobilePhoneNo = str;
        this.bankToken = str2;
        this.cardBin = str3;
        this.cardCacheToken = str4;
        this.dailyLimit = str5;
        this.bizProcessId = str6;
        this.cardScheme = str7;
        this.ektp = str8;
        this.interbankSupport = str9;
        this.headerDescription = str10;
        this.serviceInstID = str11;
        this.needRegistration = bool;
    }

    public /* synthetic */ ExtendInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (i & 1024) != 0 ? null : str11, bool);
    }

    @JvmName(name = "getBankMobilePhoneNo")
    public final String getBankMobilePhoneNo() {
        return this.bankMobilePhoneNo;
    }

    @JvmName(name = "getBankToken")
    public final String getBankToken() {
        return this.bankToken;
    }

    @JvmName(name = "getCardBin")
    public final String getCardBin() {
        return this.cardBin;
    }

    @JvmName(name = "getCardCacheToken")
    public final String getCardCacheToken() {
        return this.cardCacheToken;
    }

    @JvmName(name = "getDailyLimit")
    public final String getDailyLimit() {
        return this.dailyLimit;
    }

    @JvmName(name = "getBizProcessId")
    public final String getBizProcessId() {
        return this.bizProcessId;
    }

    @JvmName(name = "getCardScheme")
    public final String getCardScheme() {
        return this.cardScheme;
    }

    @JvmName(name = "getEktp")
    public final String getEktp() {
        return this.ektp;
    }

    @JvmName(name = "getInterbankSupport")
    public final String getInterbankSupport() {
        return this.interbankSupport;
    }

    @JvmName(name = "getHeaderDescription")
    public final String getHeaderDescription() {
        return this.headerDescription;
    }

    @JvmName(name = "getServiceInstID")
    public final String getServiceInstID() {
        return this.serviceInstID;
    }

    @JvmName(name = "getNeedRegistration")
    public final Boolean getNeedRegistration() {
        return this.needRegistration;
    }
}
