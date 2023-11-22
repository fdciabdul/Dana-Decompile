package id.dana.network.response.autoroute;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\r\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010&"}, d2 = {"Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/network/response/autoroute/RiskResult;", "component1", "()Lid/dana/network/response/autoroute/RiskResult;", "Lid/dana/network/response/autoroute/SecurityContextResult;", "component2", "()Lid/dana/network/response/autoroute/SecurityContextResult;", "Lid/dana/network/response/autoroute/UserAutoRouteSwitchAttributeResult;", "component3", "()Lid/dana/network/response/autoroute/UserAutoRouteSwitchAttributeResult;", "riskResult", "securityContext", "attributes", "copy", "(Lid/dana/network/response/autoroute/RiskResult;Lid/dana/network/response/autoroute/SecurityContextResult;Lid/dana/network/response/autoroute/UserAutoRouteSwitchAttributeResult;)Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/network/response/autoroute/UserAutoRouteSwitchAttributeResult;", "getAttributes", "setAttributes", "(Lid/dana/network/response/autoroute/UserAutoRouteSwitchAttributeResult;)V", "Lid/dana/network/response/autoroute/RiskResult;", "getRiskResult", "setRiskResult", "(Lid/dana/network/response/autoroute/RiskResult;)V", "Lid/dana/network/response/autoroute/SecurityContextResult;", "getSecurityContext", "setSecurityContext", "(Lid/dana/network/response/autoroute/SecurityContextResult;)V", "<init>", "(Lid/dana/network/response/autoroute/RiskResult;Lid/dana/network/response/autoroute/SecurityContextResult;Lid/dana/network/response/autoroute/UserAutoRouteSwitchAttributeResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserAutoRouteConfigSwitchResult extends BaseRpcResult {
    private UserAutoRouteSwitchAttributeResult attributes;
    private RiskResult riskResult;
    private SecurityContextResult securityContext;

    public UserAutoRouteConfigSwitchResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UserAutoRouteConfigSwitchResult copy$default(UserAutoRouteConfigSwitchResult userAutoRouteConfigSwitchResult, RiskResult riskResult, SecurityContextResult securityContextResult, UserAutoRouteSwitchAttributeResult userAutoRouteSwitchAttributeResult, int i, Object obj) {
        if ((i & 1) != 0) {
            riskResult = userAutoRouteConfigSwitchResult.riskResult;
        }
        if ((i & 2) != 0) {
            securityContextResult = userAutoRouteConfigSwitchResult.securityContext;
        }
        if ((i & 4) != 0) {
            userAutoRouteSwitchAttributeResult = userAutoRouteConfigSwitchResult.attributes;
        }
        return userAutoRouteConfigSwitchResult.copy(riskResult, securityContextResult, userAutoRouteSwitchAttributeResult);
    }

    /* renamed from: component1  reason: from getter */
    public final RiskResult getRiskResult() {
        return this.riskResult;
    }

    /* renamed from: component2  reason: from getter */
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    /* renamed from: component3  reason: from getter */
    public final UserAutoRouteSwitchAttributeResult getAttributes() {
        return this.attributes;
    }

    public final UserAutoRouteConfigSwitchResult copy(RiskResult riskResult, SecurityContextResult securityContext, UserAutoRouteSwitchAttributeResult attributes) {
        return new UserAutoRouteConfigSwitchResult(riskResult, securityContext, attributes);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAutoRouteConfigSwitchResult) {
            UserAutoRouteConfigSwitchResult userAutoRouteConfigSwitchResult = (UserAutoRouteConfigSwitchResult) other;
            return Intrinsics.areEqual(this.riskResult, userAutoRouteConfigSwitchResult.riskResult) && Intrinsics.areEqual(this.securityContext, userAutoRouteConfigSwitchResult.securityContext) && Intrinsics.areEqual(this.attributes, userAutoRouteConfigSwitchResult.attributes);
        }
        return false;
    }

    public final int hashCode() {
        RiskResult riskResult = this.riskResult;
        int hashCode = riskResult == null ? 0 : riskResult.hashCode();
        SecurityContextResult securityContextResult = this.securityContext;
        int hashCode2 = securityContextResult == null ? 0 : securityContextResult.hashCode();
        UserAutoRouteSwitchAttributeResult userAutoRouteSwitchAttributeResult = this.attributes;
        return (((hashCode * 31) + hashCode2) * 31) + (userAutoRouteSwitchAttributeResult != null ? userAutoRouteSwitchAttributeResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAutoRouteConfigSwitchResult(riskResult=");
        sb.append(this.riskResult);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserAutoRouteConfigSwitchResult(RiskResult riskResult, SecurityContextResult securityContextResult, UserAutoRouteSwitchAttributeResult userAutoRouteSwitchAttributeResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : riskResult, (i & 2) != 0 ? null : securityContextResult, (i & 4) != 0 ? null : userAutoRouteSwitchAttributeResult);
    }

    @JvmName(name = "getRiskResult")
    public final RiskResult getRiskResult() {
        return this.riskResult;
    }

    @JvmName(name = "setRiskResult")
    public final void setRiskResult(RiskResult riskResult) {
        this.riskResult = riskResult;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    @JvmName(name = "setSecurityContext")
    public final void setSecurityContext(SecurityContextResult securityContextResult) {
        this.securityContext = securityContextResult;
    }

    @JvmName(name = "getAttributes")
    public final UserAutoRouteSwitchAttributeResult getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "setAttributes")
    public final void setAttributes(UserAutoRouteSwitchAttributeResult userAutoRouteSwitchAttributeResult) {
        this.attributes = userAutoRouteSwitchAttributeResult;
    }

    public UserAutoRouteConfigSwitchResult(RiskResult riskResult, SecurityContextResult securityContextResult, UserAutoRouteSwitchAttributeResult userAutoRouteSwitchAttributeResult) {
        this.riskResult = riskResult;
        this.securityContext = securityContextResult;
        this.attributes = userAutoRouteSwitchAttributeResult;
    }
}
