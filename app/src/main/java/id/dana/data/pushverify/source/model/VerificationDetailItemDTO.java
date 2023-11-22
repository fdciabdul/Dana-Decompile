package id.dana.data.pushverify.source.model;

import com.alipay.multigateway.sdk.adapter.network.quake.QuakeSGSignatureHandler;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004Jt\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b+\u0010\u0004"}, d2 = {"Lid/dana/data/pushverify/source/model/VerificationDetailItemDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Integer;", "component7", "component8", "component9", "merchantName", "requestTime", QuakeSGSignatureHandler.REQUEST_TYPE, DecodedScanBizInfoKey.LOGO_URL, "verificationStatus", "expiryTime", BranchLinkConstant.PushVerifyParams.TRANSACTION_ID, "token", "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/pushverify/source/model/VerificationDetailItemDTO;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCacheKey", "Ljava/lang/Integer;", "getExpiryTime", "getLogoUrl", "getMerchantName", "getRequestTime", "getRequestType", "getToken", "getTrxId", "getVerificationStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerificationDetailItemDTO {
    private final String cacheKey;
    private final Integer expiryTime;
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
    public final Integer getExpiryTime() {
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

    public final VerificationDetailItemDTO copy(String merchantName, String requestTime, String requestType, String logoUrl, String verificationStatus, Integer expiryTime, String trxId, String token, String cacheKey) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(requestTime, "");
        Intrinsics.checkNotNullParameter(requestType, "");
        Intrinsics.checkNotNullParameter(verificationStatus, "");
        return new VerificationDetailItemDTO(merchantName, requestTime, requestType, logoUrl, verificationStatus, expiryTime, trxId, token, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerificationDetailItemDTO) {
            VerificationDetailItemDTO verificationDetailItemDTO = (VerificationDetailItemDTO) other;
            return Intrinsics.areEqual(this.merchantName, verificationDetailItemDTO.merchantName) && Intrinsics.areEqual(this.requestTime, verificationDetailItemDTO.requestTime) && Intrinsics.areEqual(this.requestType, verificationDetailItemDTO.requestType) && Intrinsics.areEqual(this.logoUrl, verificationDetailItemDTO.logoUrl) && Intrinsics.areEqual(this.verificationStatus, verificationDetailItemDTO.verificationStatus) && Intrinsics.areEqual(this.expiryTime, verificationDetailItemDTO.expiryTime) && Intrinsics.areEqual(this.trxId, verificationDetailItemDTO.trxId) && Intrinsics.areEqual(this.token, verificationDetailItemDTO.token) && Intrinsics.areEqual(this.cacheKey, verificationDetailItemDTO.cacheKey);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.merchantName.hashCode();
        int hashCode2 = this.requestTime.hashCode();
        int hashCode3 = this.requestType.hashCode();
        String str = this.logoUrl;
        int hashCode4 = str == null ? 0 : str.hashCode();
        int hashCode5 = this.verificationStatus.hashCode();
        Integer num = this.expiryTime;
        int hashCode6 = num == null ? 0 : num.hashCode();
        String str2 = this.trxId;
        int hashCode7 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.token;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cacheKey;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerificationDetailItemDTO(merchantName=");
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

    public VerificationDetailItemDTO(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.merchantName = str;
        this.requestTime = str2;
        this.requestType = str3;
        this.logoUrl = str4;
        this.verificationStatus = str5;
        this.expiryTime = num;
        this.trxId = str6;
        this.token = str7;
        this.cacheKey = str8;
    }

    public /* synthetic */ VerificationDetailItemDTO(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8);
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
