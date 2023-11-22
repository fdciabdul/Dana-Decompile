package id.dana.riskChallenges.data.danaprotection.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.errorprone.annotations.Keep;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J^\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b#\u0010\u0004R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\t"}, d2 = {"Lid/dana/riskChallenges/data/danaprotection/source/network/result/RiskChallengeStatusResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "component3", "()Ljava/util/List;", "component4", "component5", "component6", "riskResult", BioUtilityBridge.SECURITY_ID, "verificationMethods", "riskInfo", "ctaResult", "journeySuggestion", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/riskChallenges/data/danaprotection/source/network/result/RiskChallengeStatusResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCtaResult", "getJourneySuggestion", "getRiskInfo", "getRiskResult", "getSecurityId", "Ljava/util/List;", "getVerificationMethods", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RiskChallengeStatusResult extends BaseRpcResult {
    @SerializedName("ctaResult")
    private final String ctaResult;
    @SerializedName("journeySuggestion")
    private final String journeySuggestion;
    @SerializedName("riskInfo")
    private final String riskInfo;
    @SerializedName("riskResult")
    private final String riskResult;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("verificationMethods")
    private final List<VerificationMethodInfoEntity> verificationMethods;

    public RiskChallengeStatusResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ RiskChallengeStatusResult copy$default(RiskChallengeStatusResult riskChallengeStatusResult, String str, String str2, List list, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = riskChallengeStatusResult.riskResult;
        }
        if ((i & 2) != 0) {
            str2 = riskChallengeStatusResult.securityId;
        }
        String str6 = str2;
        List<VerificationMethodInfoEntity> list2 = list;
        if ((i & 4) != 0) {
            list2 = riskChallengeStatusResult.verificationMethods;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            str3 = riskChallengeStatusResult.riskInfo;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = riskChallengeStatusResult.ctaResult;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = riskChallengeStatusResult.journeySuggestion;
        }
        return riskChallengeStatusResult.copy(str, str6, list3, str7, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRiskResult() {
        return this.riskResult;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<VerificationMethodInfoEntity> component3() {
        return this.verificationMethods;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRiskInfo() {
        return this.riskInfo;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCtaResult() {
        return this.ctaResult;
    }

    /* renamed from: component6  reason: from getter */
    public final String getJourneySuggestion() {
        return this.journeySuggestion;
    }

    public final RiskChallengeStatusResult copy(@JSONField(name = "riskResult") String riskResult, @JSONField(name = "securityId") String securityId, @JSONField(name = "verificationMethods") List<VerificationMethodInfoEntity> verificationMethods, @JSONField(name = "riskInfo") String riskInfo, @JSONField(name = "ctaResult") String ctaResult, @JSONField(name = "journeySuggestion") String journeySuggestion) {
        return new RiskChallengeStatusResult(riskResult, securityId, verificationMethods, riskInfo, ctaResult, journeySuggestion);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskChallengeStatusResult) {
            RiskChallengeStatusResult riskChallengeStatusResult = (RiskChallengeStatusResult) other;
            return Intrinsics.areEqual(this.riskResult, riskChallengeStatusResult.riskResult) && Intrinsics.areEqual(this.securityId, riskChallengeStatusResult.securityId) && Intrinsics.areEqual(this.verificationMethods, riskChallengeStatusResult.verificationMethods) && Intrinsics.areEqual(this.riskInfo, riskChallengeStatusResult.riskInfo) && Intrinsics.areEqual(this.ctaResult, riskChallengeStatusResult.ctaResult) && Intrinsics.areEqual(this.journeySuggestion, riskChallengeStatusResult.journeySuggestion);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.riskResult;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        List<VerificationMethodInfoEntity> list = this.verificationMethods;
        int hashCode3 = list == null ? 0 : list.hashCode();
        String str3 = this.riskInfo;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.ctaResult;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.journeySuggestion;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskChallengeStatusResult(riskResult=");
        sb.append(this.riskResult);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(", riskInfo=");
        sb.append(this.riskInfo);
        sb.append(", ctaResult=");
        sb.append(this.ctaResult);
        sb.append(", journeySuggestion=");
        sb.append(this.journeySuggestion);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ RiskChallengeStatusResult(String str, String str2, List list, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    @JvmName(name = "getRiskResult")
    public final String getRiskResult() {
        return this.riskResult;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerificationMethods")
    public final List<VerificationMethodInfoEntity> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "getRiskInfo")
    public final String getRiskInfo() {
        return this.riskInfo;
    }

    @JvmName(name = "getCtaResult")
    public final String getCtaResult() {
        return this.ctaResult;
    }

    @JvmName(name = "getJourneySuggestion")
    public final String getJourneySuggestion() {
        return this.journeySuggestion;
    }

    public RiskChallengeStatusResult(@JSONField(name = "riskResult") String str, @JSONField(name = "securityId") String str2, @JSONField(name = "verificationMethods") List<VerificationMethodInfoEntity> list, @JSONField(name = "riskInfo") String str3, @JSONField(name = "ctaResult") String str4, @JSONField(name = "journeySuggestion") String str5) {
        this.riskResult = str;
        this.securityId = str2;
        this.verificationMethods = list;
        this.riskInfo = str3;
        this.ctaResult = str4;
        this.journeySuggestion = str5;
    }
}
