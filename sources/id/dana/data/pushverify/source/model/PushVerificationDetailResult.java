package id.dana.data.pushverify.source.model;

import com.alipay.multigateway.sdk.adapter.network.quake.QuakeSGSignatureHandler;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b/\u00100J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0088\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b.\u0010\u0004"}, d2 = {"Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "component8", "component9", "merchantId", "merchantName", "device", "requestTime", QuakeSGSignatureHandler.REQUEST_TYPE, DecodedScanBizInfoKey.LOGO_URL, "expiryTime", BranchLinkConstant.PushVerifyParams.TRANSACTION_ID, "token", "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/pushverify/source/model/PushVerificationDetailResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCacheKey", "getDevice", "Ljava/lang/Integer;", "getExpiryTime", "getLogoUrl", "getMerchantId", "getMerchantName", "getRequestTime", "getRequestType", "getToken", "getTrxId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerificationDetailResult {
    private final String cacheKey;
    private final String device;
    private final Integer expiryTime;
    private final String logoUrl;
    private final String merchantId;
    private final String merchantName;
    private final String requestTime;
    private final String requestType;
    private final String token;
    private final String trxId;

    public PushVerificationDetailResult() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRequestType() {
        return this.requestType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final Integer getExpiryTime() {
        return this.expiryTime;
    }

    /* renamed from: component8  reason: from getter */
    public final String getTrxId() {
        return this.trxId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final PushVerificationDetailResult copy(String merchantId, String merchantName, String device, String requestTime, String requestType, String logoUrl, Integer expiryTime, String trxId, String token, String cacheKey) {
        return new PushVerificationDetailResult(merchantId, merchantName, device, requestTime, requestType, logoUrl, expiryTime, trxId, token, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerificationDetailResult) {
            PushVerificationDetailResult pushVerificationDetailResult = (PushVerificationDetailResult) other;
            return Intrinsics.areEqual(this.merchantId, pushVerificationDetailResult.merchantId) && Intrinsics.areEqual(this.merchantName, pushVerificationDetailResult.merchantName) && Intrinsics.areEqual(this.device, pushVerificationDetailResult.device) && Intrinsics.areEqual(this.requestTime, pushVerificationDetailResult.requestTime) && Intrinsics.areEqual(this.requestType, pushVerificationDetailResult.requestType) && Intrinsics.areEqual(this.logoUrl, pushVerificationDetailResult.logoUrl) && Intrinsics.areEqual(this.expiryTime, pushVerificationDetailResult.expiryTime) && Intrinsics.areEqual(this.trxId, pushVerificationDetailResult.trxId) && Intrinsics.areEqual(this.token, pushVerificationDetailResult.token) && Intrinsics.areEqual(this.cacheKey, pushVerificationDetailResult.cacheKey);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.merchantId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.merchantName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.device;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.requestTime;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.requestType;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.logoUrl;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        Integer num = this.expiryTime;
        int hashCode7 = num == null ? 0 : num.hashCode();
        String str7 = this.trxId;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.token;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.cacheKey;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerificationDetailResult(merchantId=");
        sb.append(this.merchantId);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", requestTime=");
        sb.append(this.requestTime);
        sb.append(", requestType=");
        sb.append(this.requestType);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", expiryTime=");
        sb.append(this.expiryTime);
        sb.append(", trxId=");
        sb.append(this.trxId);
        sb.append(", token=");
        sb.append(this.token);
        sb.append(", cacheKey=");
        sb.append(this.cacheKey);
        sb.append(')');
        return sb.toString();
    }

    public PushVerificationDetailResult(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9) {
        this.merchantId = str;
        this.merchantName = str2;
        this.device = str3;
        this.requestTime = str4;
        this.requestType = str5;
        this.logoUrl = str6;
        this.expiryTime = num;
        this.trxId = str7;
        this.token = str8;
        this.cacheKey = str9;
    }

    public /* synthetic */ PushVerificationDetailResult(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) == 0 ? str9 : null);
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getDevice")
    public final String getDevice() {
        return this.device;
    }

    @JvmName(name = "getRequestTime")
    public final String getRequestTime() {
        return this.requestTime;
    }

    @JvmName(name = "getRequestType")
    public final String getRequestType() {
        return this.requestType;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getExpiryTime")
    public final Integer getExpiryTime() {
        return this.expiryTime;
    }

    @JvmName(name = "getTrxId")
    public final String getTrxId() {
        return this.trxId;
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "getCacheKey")
    public final String getCacheKey() {
        return this.cacheKey;
    }
}
