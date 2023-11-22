package id.dana.data.promocode.repository.source.network.result;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.data.constant.UrlParam;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0092\u0001\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b,\u0010\u0004R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\u0013R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b5\u0010\u0004"}, d2 = {"Lid/dana/data/promocode/repository/source/network/result/PrizeAwardVOResult;", "", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/Map;", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()J", "Lid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;", "component9", "()Lid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;", "prizeAwardOrderId", "status", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "merchantId", "userId", UrlParam.REQUEST_ID, "bizNo", "awardTime", "prizeInfoVO", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;Ljava/util/Map;)Lid/dana/data/promocode/repository/source/network/result/PrizeAwardVOResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityId", "J", "getAwardTime", "getBizNo", "Ljava/util/Map;", "getExtendInfo", "getMerchantId", "getPrizeAwardOrderId", "Lid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;", "getPrizeInfoVO", "getRequestId", "getStatus", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PrizeAwardVOResult {
    private final String activityId;
    private final long awardTime;
    private final String bizNo;
    private final Map<String, String> extendInfo;
    private final String merchantId;
    private final String prizeAwardOrderId;
    private final PrizeInfoVOResult prizeInfoVO;
    private final String requestId;
    private final String status;
    private final String userId;

    /* renamed from: component1  reason: from getter */
    public final String getPrizeAwardOrderId() {
        return this.prizeAwardOrderId;
    }

    public final Map<String, String> component10() {
        return this.extendInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    /* renamed from: component8  reason: from getter */
    public final long getAwardTime() {
        return this.awardTime;
    }

    /* renamed from: component9  reason: from getter */
    public final PrizeInfoVOResult getPrizeInfoVO() {
        return this.prizeInfoVO;
    }

    public final PrizeAwardVOResult copy(String prizeAwardOrderId, String status, String activityId, String merchantId, String userId, String requestId, String bizNo, long awardTime, PrizeInfoVOResult prizeInfoVO, Map<String, String> extendInfo) {
        return new PrizeAwardVOResult(prizeAwardOrderId, status, activityId, merchantId, userId, requestId, bizNo, awardTime, prizeInfoVO, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PrizeAwardVOResult) {
            PrizeAwardVOResult prizeAwardVOResult = (PrizeAwardVOResult) other;
            return Intrinsics.areEqual(this.prizeAwardOrderId, prizeAwardVOResult.prizeAwardOrderId) && Intrinsics.areEqual(this.status, prizeAwardVOResult.status) && Intrinsics.areEqual(this.activityId, prizeAwardVOResult.activityId) && Intrinsics.areEqual(this.merchantId, prizeAwardVOResult.merchantId) && Intrinsics.areEqual(this.userId, prizeAwardVOResult.userId) && Intrinsics.areEqual(this.requestId, prizeAwardVOResult.requestId) && Intrinsics.areEqual(this.bizNo, prizeAwardVOResult.bizNo) && this.awardTime == prizeAwardVOResult.awardTime && Intrinsics.areEqual(this.prizeInfoVO, prizeAwardVOResult.prizeInfoVO) && Intrinsics.areEqual(this.extendInfo, prizeAwardVOResult.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.prizeAwardOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.status;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.activityId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.userId;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.requestId;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.bizNo;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.awardTime);
        PrizeInfoVOResult prizeInfoVOResult = this.prizeInfoVO;
        int hashCode8 = prizeInfoVOResult == null ? 0 : prizeInfoVOResult.hashCode();
        Map<String, String> map = this.extendInfo;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + m) * 31) + hashCode8) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrizeAwardVOResult(prizeAwardOrderId=");
        sb.append(this.prizeAwardOrderId);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", bizNo=");
        sb.append(this.bizNo);
        sb.append(", awardTime=");
        sb.append(this.awardTime);
        sb.append(", prizeInfoVO=");
        sb.append(this.prizeInfoVO);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public PrizeAwardVOResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, PrizeInfoVOResult prizeInfoVOResult, Map<String, String> map) {
        this.prizeAwardOrderId = str;
        this.status = str2;
        this.activityId = str3;
        this.merchantId = str4;
        this.userId = str5;
        this.requestId = str6;
        this.bizNo = str7;
        this.awardTime = j;
        this.prizeInfoVO = prizeInfoVOResult;
        this.extendInfo = map;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getPrizeAwardOrderId")
    public final String getPrizeAwardOrderId() {
        return this.prizeAwardOrderId;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getBizNo")
    public final String getBizNo() {
        return this.bizNo;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getAwardTime")
    public final long getAwardTime() {
        return this.awardTime;
    }

    @JvmName(name = "getPrizeInfoVO")
    public final PrizeInfoVOResult getPrizeInfoVO() {
        return this.prizeInfoVO;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
