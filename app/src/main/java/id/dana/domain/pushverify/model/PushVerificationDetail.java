package id.dana.domain.pushverify.model;

import com.alipay.multigateway.sdk.adapter.network.quake.QuakeSGSignatureHandler;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b \u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/domain/pushverify/model/PushVerificationDetail;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()I", "merchantId", "merchantName", "device", "requestTime", QuakeSGSignatureHandler.REQUEST_TYPE, DecodedScanBizInfoKey.LOGO_URL, "expiryTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lid/dana/domain/pushverify/model/PushVerificationDetail;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getDevice", "I", "getExpiryTime", "getLogoUrl", "getMerchantId", "getMerchantName", "getRequestTime", "getRequestType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerificationDetail {
    public static final int NO_EXPIRY_TIME = 0;
    private final String device;
    private final int expiryTime;
    private final String logoUrl;
    private final String merchantId;
    private final String merchantName;
    private final String requestTime;
    private final String requestType;

    public static /* synthetic */ PushVerificationDetail copy$default(PushVerificationDetail pushVerificationDetail, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pushVerificationDetail.merchantId;
        }
        if ((i2 & 2) != 0) {
            str2 = pushVerificationDetail.merchantName;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = pushVerificationDetail.device;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = pushVerificationDetail.requestTime;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = pushVerificationDetail.requestType;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = pushVerificationDetail.logoUrl;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            i = pushVerificationDetail.expiryTime;
        }
        return pushVerificationDetail.copy(str, str7, str8, str9, str10, str11, i);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
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
    public final int getExpiryTime() {
        return this.expiryTime;
    }

    public final PushVerificationDetail copy(String merchantId, String merchantName, String device, String requestTime, String requestType, String logoUrl, int expiryTime) {
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(device, "");
        Intrinsics.checkNotNullParameter(requestTime, "");
        Intrinsics.checkNotNullParameter(requestType, "");
        Intrinsics.checkNotNullParameter(logoUrl, "");
        return new PushVerificationDetail(merchantId, merchantName, device, requestTime, requestType, logoUrl, expiryTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerificationDetail) {
            PushVerificationDetail pushVerificationDetail = (PushVerificationDetail) other;
            return Intrinsics.areEqual(this.merchantId, pushVerificationDetail.merchantId) && Intrinsics.areEqual(this.merchantName, pushVerificationDetail.merchantName) && Intrinsics.areEqual(this.device, pushVerificationDetail.device) && Intrinsics.areEqual(this.requestTime, pushVerificationDetail.requestTime) && Intrinsics.areEqual(this.requestType, pushVerificationDetail.requestType) && Intrinsics.areEqual(this.logoUrl, pushVerificationDetail.logoUrl) && this.expiryTime == pushVerificationDetail.expiryTime;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.merchantId.hashCode() * 31) + this.merchantName.hashCode()) * 31) + this.device.hashCode()) * 31) + this.requestTime.hashCode()) * 31) + this.requestType.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.expiryTime;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerificationDetail(merchantId=");
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
        sb.append(')');
        return sb.toString();
    }

    public PushVerificationDetail(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.merchantId = str;
        this.merchantName = str2;
        this.device = str3;
        this.requestTime = str4;
        this.requestType = str5;
        this.logoUrl = str6;
        this.expiryTime = i;
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
    public final int getExpiryTime() {
        return this.expiryTime;
    }
}
