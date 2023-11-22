package id.dana.domain.pushverify.model;

import com.alipay.multigateway.sdk.adapter.network.quake.QuakeSGSignatureHandler;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BO\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004Jj\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0017\u0010\u0017\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/domain/pushverify/model/VerificationDetailItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()I", "component7", "component8", "component9", "merchantName", "requestTime", QuakeSGSignatureHandler.REQUEST_TYPE, DecodedScanBizInfoKey.LOGO_URL, "verificationStatus", "expiryTime", BranchLinkConstant.PushVerifyParams.TRANSACTION_ID, "token", "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/pushverify/model/VerificationDetailItem;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getCacheKey", "I", "getExpiryTime", "getLogoUrl", "getMerchantName", "getRequestTime", "getRequestType", "getToken", "getTrxId", "getVerificationStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerificationDetailItem {
    public static final int NO_EXPIRY_TIME = 0;
    private final String cacheKey;
    private final int expiryTime;
    private final String logoUrl;
    private final String merchantName;
    private final String requestTime;
    private final String requestType;
    private final String token;
    private final String trxId;
    private final String verificationStatus;

    /* renamed from: component1  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRequestType() {
        return this.requestType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final String getVerificationStatus() {
        return this.verificationStatus;
    }

    /* renamed from: component6  reason: from getter */
    public final int getExpiryTime() {
        return this.expiryTime;
    }

    /* renamed from: component7  reason: from getter */
    public final String getTrxId() {
        return this.trxId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component9  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final VerificationDetailItem copy(String merchantName, String requestTime, String requestType, String logoUrl, String verificationStatus, int expiryTime, String trxId, String token, String cacheKey) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(requestTime, "");
        Intrinsics.checkNotNullParameter(requestType, "");
        Intrinsics.checkNotNullParameter(logoUrl, "");
        Intrinsics.checkNotNullParameter(verificationStatus, "");
        Intrinsics.checkNotNullParameter(trxId, "");
        Intrinsics.checkNotNullParameter(token, "");
        Intrinsics.checkNotNullParameter(cacheKey, "");
        return new VerificationDetailItem(merchantName, requestTime, requestType, logoUrl, verificationStatus, expiryTime, trxId, token, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerificationDetailItem) {
            VerificationDetailItem verificationDetailItem = (VerificationDetailItem) other;
            return Intrinsics.areEqual(this.merchantName, verificationDetailItem.merchantName) && Intrinsics.areEqual(this.requestTime, verificationDetailItem.requestTime) && Intrinsics.areEqual(this.requestType, verificationDetailItem.requestType) && Intrinsics.areEqual(this.logoUrl, verificationDetailItem.logoUrl) && Intrinsics.areEqual(this.verificationStatus, verificationDetailItem.verificationStatus) && this.expiryTime == verificationDetailItem.expiryTime && Intrinsics.areEqual(this.trxId, verificationDetailItem.trxId) && Intrinsics.areEqual(this.token, verificationDetailItem.token) && Intrinsics.areEqual(this.cacheKey, verificationDetailItem.cacheKey);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((this.merchantName.hashCode() * 31) + this.requestTime.hashCode()) * 31) + this.requestType.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.verificationStatus.hashCode()) * 31) + this.expiryTime) * 31) + this.trxId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.cacheKey.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerificationDetailItem(merchantName=");
        sb.append(this.merchantName);
        sb.append(", requestTime=");
        sb.append(this.requestTime);
        sb.append(", requestType=");
        sb.append(this.requestType);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", verificationStatus=");
        sb.append(this.verificationStatus);
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

    public VerificationDetailItem(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.merchantName = str;
        this.requestTime = str2;
        this.requestType = str3;
        this.logoUrl = str4;
        this.verificationStatus = str5;
        this.expiryTime = i;
        this.trxId = str6;
        this.token = str7;
        this.cacheKey = str8;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
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

    @JvmName(name = "getVerificationStatus")
    public final String getVerificationStatus() {
        return this.verificationStatus;
    }

    @JvmName(name = "getExpiryTime")
    public final int getExpiryTime() {
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
