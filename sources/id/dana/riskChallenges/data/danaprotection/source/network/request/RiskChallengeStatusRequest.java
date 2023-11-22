package id.dana.riskChallenges.data.danaprotection.source.network.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/danaprotection/source/network/request/RiskChallengeStatusRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "userId", "eventId", "action", BioUtilityBridge.SECURITY_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/riskChallenges/data/danaprotection/source/network/request/RiskChallengeStatusRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "getEventId", "getSecurityId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RiskChallengeStatusRequest extends BaseRpcRequest {
    @SerializedName("action")
    private final String action;
    @SerializedName("eventId")
    private final String eventId;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("userId")
    private final String userId;

    public static /* synthetic */ RiskChallengeStatusRequest copy$default(RiskChallengeStatusRequest riskChallengeStatusRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = riskChallengeStatusRequest.userId;
        }
        if ((i & 2) != 0) {
            str2 = riskChallengeStatusRequest.eventId;
        }
        if ((i & 4) != 0) {
            str3 = riskChallengeStatusRequest.action;
        }
        if ((i & 8) != 0) {
            str4 = riskChallengeStatusRequest.securityId;
        }
        return riskChallengeStatusRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final RiskChallengeStatusRequest copy(@JSONField(name = "userId") String userId, @JSONField(name = "eventId") String eventId, @JSONField(name = "action") String action, @JSONField(name = "securityId") String securityId) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(eventId, "");
        Intrinsics.checkNotNullParameter(action, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        return new RiskChallengeStatusRequest(userId, eventId, action, securityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskChallengeStatusRequest) {
            RiskChallengeStatusRequest riskChallengeStatusRequest = (RiskChallengeStatusRequest) other;
            return Intrinsics.areEqual(this.userId, riskChallengeStatusRequest.userId) && Intrinsics.areEqual(this.eventId, riskChallengeStatusRequest.eventId) && Intrinsics.areEqual(this.action, riskChallengeStatusRequest.action) && Intrinsics.areEqual(this.securityId, riskChallengeStatusRequest.securityId);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.eventId.hashCode()) * 31) + this.action.hashCode()) * 31) + this.securityId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskChallengeStatusRequest(userId=");
        sb.append(this.userId);
        sb.append(", eventId=");
        sb.append(this.eventId);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    public RiskChallengeStatusRequest(@JSONField(name = "userId") String str, @JSONField(name = "eventId") String str2, @JSONField(name = "action") String str3, @JSONField(name = "securityId") String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.userId = str;
        this.eventId = str2;
        this.action = str3;
        this.securityId = str4;
    }
}
