package id.dana.data.qrbarcode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import id.dana.data.constant.UrlParam;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0088\u0001\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b-\u0010\u0004"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/request/PreCreateOrderEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "qrCode", "amount", UrlParam.REQUEST_ID, "merchantId", "tip", "bizType", "cacheKey", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, SummaryActivity.FIRST_STATE_SHARE_FEED, "userName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/qrbarcode/repository/source/network/request/PreCreateOrderEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getBizType", "getCacheKey", "getCountryCode", "getFirstTime", "getMerchantId", "getQrCode", "getRequestId", "getTip", "getUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PreCreateOrderEntityRequest extends BaseRpcRequest {
    private final String amount;
    private final String bizType;
    private final String cacheKey;
    private final String countryCode;
    private final String firstTime;
    private final String merchantId;
    @SerializedName("qrCode")
    private final String qrCode;
    private final String requestId;
    private final String tip;
    private final String userName;

    /* renamed from: component1  reason: from getter */
    public final String getQrCode() {
        return this.qrCode;
    }

    /* renamed from: component10  reason: from getter */
    public final String getUserName() {
        return this.userName;
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

    public final PreCreateOrderEntityRequest copy(String qrCode, String amount, String requestId, String merchantId, String tip, String bizType, String cacheKey, String countryCode, String firstTime, String userName) {
        return new PreCreateOrderEntityRequest(qrCode, amount, requestId, merchantId, tip, bizType, cacheKey, countryCode, firstTime, userName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PreCreateOrderEntityRequest) {
            PreCreateOrderEntityRequest preCreateOrderEntityRequest = (PreCreateOrderEntityRequest) other;
            return Intrinsics.areEqual(this.qrCode, preCreateOrderEntityRequest.qrCode) && Intrinsics.areEqual(this.amount, preCreateOrderEntityRequest.amount) && Intrinsics.areEqual(this.requestId, preCreateOrderEntityRequest.requestId) && Intrinsics.areEqual(this.merchantId, preCreateOrderEntityRequest.merchantId) && Intrinsics.areEqual(this.tip, preCreateOrderEntityRequest.tip) && Intrinsics.areEqual(this.bizType, preCreateOrderEntityRequest.bizType) && Intrinsics.areEqual(this.cacheKey, preCreateOrderEntityRequest.cacheKey) && Intrinsics.areEqual(this.countryCode, preCreateOrderEntityRequest.countryCode) && Intrinsics.areEqual(this.firstTime, preCreateOrderEntityRequest.firstTime) && Intrinsics.areEqual(this.userName, preCreateOrderEntityRequest.userName);
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
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreCreateOrderEntityRequest(qrCode=");
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
        sb.append(')');
        return sb.toString();
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

    public PreCreateOrderEntityRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
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
    }
}
