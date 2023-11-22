package id.dana.cashier.domain.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.data.constant.UrlParam;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J¸\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b1\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010+\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b3\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010+\u001a\u0004\b4\u0010\u0004R$\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00105\u001a\u0004\b6\u0010\b\"\u0004\b7\u00108R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b9\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b;\u0010\u0004R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010+\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010>"}, d2 = {"Lid/dana/cashier/domain/model/CreateOrderRequest;", "", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "qrCode", "amount", UrlParam.REQUEST_ID, "merchantId", "tip", "bizType", "cacheKey", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, SummaryActivity.FIRST_STATE_SHARE_FEED, "userName", "precreateOrder", "crossBorder", "merchantCity", "postalCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/CreateOrderRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getBizType", "getCacheKey", "getCountryCode", "getCrossBorder", "getFirstTime", "getMerchantCity", "getMerchantId", "getPostalCode", "Ljava/lang/Boolean;", "getPrecreateOrder", "setPrecreateOrder", "(Ljava/lang/Boolean;)V", "getQrCode", "getRequestId", "getTip", "getUserName", "setUserName", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderRequest {
    private final String amount;
    private final String bizType;
    private final String cacheKey;
    private final String countryCode;
    private final String crossBorder;
    private final String firstTime;
    private final String merchantCity;
    private final String merchantId;
    private final String postalCode;
    private Boolean precreateOrder;
    private final String qrCode;
    private final String requestId;
    private final String tip;
    private String userName;

    /* renamed from: component1  reason: from getter */
    public final String getQrCode() {
        return this.qrCode;
    }

    /* renamed from: component10  reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component11  reason: from getter */
    public final Boolean getPrecreateOrder() {
        return this.precreateOrder;
    }

    /* renamed from: component12  reason: from getter */
    public final String getCrossBorder() {
        return this.crossBorder;
    }

    /* renamed from: component13  reason: from getter */
    public final String getMerchantCity() {
        return this.merchantCity;
    }

    /* renamed from: component14  reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component9  reason: from getter */
    public final String getFirstTime() {
        return this.firstTime;
    }

    public final CreateOrderRequest copy(String qrCode, String amount, String requestId, String merchantId, String tip, String bizType, String cacheKey, String countryCode, String firstTime, String userName, Boolean precreateOrder, String crossBorder, String merchantCity, String postalCode) {
        return new CreateOrderRequest(qrCode, amount, requestId, merchantId, tip, bizType, cacheKey, countryCode, firstTime, userName, precreateOrder, crossBorder, merchantCity, postalCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateOrderRequest) {
            CreateOrderRequest createOrderRequest = (CreateOrderRequest) other;
            return Intrinsics.areEqual(this.qrCode, createOrderRequest.qrCode) && Intrinsics.areEqual(this.amount, createOrderRequest.amount) && Intrinsics.areEqual(this.requestId, createOrderRequest.requestId) && Intrinsics.areEqual(this.merchantId, createOrderRequest.merchantId) && Intrinsics.areEqual(this.tip, createOrderRequest.tip) && Intrinsics.areEqual(this.bizType, createOrderRequest.bizType) && Intrinsics.areEqual(this.cacheKey, createOrderRequest.cacheKey) && Intrinsics.areEqual(this.countryCode, createOrderRequest.countryCode) && Intrinsics.areEqual(this.firstTime, createOrderRequest.firstTime) && Intrinsics.areEqual(this.userName, createOrderRequest.userName) && Intrinsics.areEqual(this.precreateOrder, createOrderRequest.precreateOrder) && Intrinsics.areEqual(this.crossBorder, createOrderRequest.crossBorder) && Intrinsics.areEqual(this.merchantCity, createOrderRequest.merchantCity) && Intrinsics.areEqual(this.postalCode, createOrderRequest.postalCode);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.qrCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.amount;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.requestId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.tip;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.bizType;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.cacheKey;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.countryCode;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.firstTime;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.userName;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        Boolean bool = this.precreateOrder;
        int hashCode11 = bool == null ? 0 : bool.hashCode();
        String str11 = this.crossBorder;
        int hashCode12 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.merchantCity;
        int hashCode13 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.postalCode;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str13 != null ? str13.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderRequest(qrCode=");
        sb.append(this.qrCode);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", tip=");
        sb.append(this.tip);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", cacheKey=");
        sb.append(this.cacheKey);
        sb.append(", countryCode=");
        sb.append(this.countryCode);
        sb.append(", firstTime=");
        sb.append(this.firstTime);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", precreateOrder=");
        sb.append(this.precreateOrder);
        sb.append(", crossBorder=");
        sb.append(this.crossBorder);
        sb.append(", merchantCity=");
        sb.append(this.merchantCity);
        sb.append(", postalCode=");
        sb.append(this.postalCode);
        sb.append(')');
        return sb.toString();
    }

    public CreateOrderRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13) {
        this.qrCode = str;
        this.amount = str2;
        this.requestId = str3;
        this.merchantId = str4;
        this.tip = str5;
        this.bizType = str6;
        this.cacheKey = str7;
        this.countryCode = str8;
        this.firstTime = str9;
        this.userName = str10;
        this.precreateOrder = bool;
        this.crossBorder = str11;
        this.merchantCity = str12;
        this.postalCode = str13;
    }

    public /* synthetic */ CreateOrderRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, (i & 512) != 0 ? null : str10, bool, str11, str12, str13);
    }

    @JvmName(name = "getQrCode")
    public final String getQrCode() {
        return this.qrCode;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getTip")
    public final String getTip() {
        return this.tip;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getCacheKey")
    public final String getCacheKey() {
        return this.cacheKey;
    }

    @JvmName(name = "getCountryCode")
    public final String getCountryCode() {
        return this.countryCode;
    }

    @JvmName(name = "getFirstTime")
    public final String getFirstTime() {
        return this.firstTime;
    }

    @JvmName(name = "getUserName")
    public final String getUserName() {
        return this.userName;
    }

    @JvmName(name = "setUserName")
    public final void setUserName(String str) {
        this.userName = str;
    }

    @JvmName(name = "getPrecreateOrder")
    public final Boolean getPrecreateOrder() {
        return this.precreateOrder;
    }

    @JvmName(name = "setPrecreateOrder")
    public final void setPrecreateOrder(Boolean bool) {
        this.precreateOrder = bool;
    }

    @JvmName(name = "getCrossBorder")
    public final String getCrossBorder() {
        return this.crossBorder;
    }

    @JvmName(name = "getMerchantCity")
    public final String getMerchantCity() {
        return this.merchantCity;
    }

    @JvmName(name = "getPostalCode")
    public final String getPostalCode() {
        return this.postalCode;
    }
}
