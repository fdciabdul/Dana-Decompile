package id.dana.domain.autoroute.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/domain/autoroute/model/UserAutoRouteConfigSwitch;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "Lid/dana/domain/autoroute/model/Risk;", "component1", "()Lid/dana/domain/autoroute/model/Risk;", "Lid/dana/domain/autoroute/model/SecurityContext;", "component2", "()Lid/dana/domain/autoroute/model/SecurityContext;", "riskResult", "securityContextResult", "copy", "(Lid/dana/domain/autoroute/model/Risk;Lid/dana/domain/autoroute/model/SecurityContext;)Lid/dana/domain/autoroute/model/UserAutoRouteConfigSwitch;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/autoroute/model/Risk;", "getRiskResult", "setRiskResult", "(Lid/dana/domain/autoroute/model/Risk;)V", "Lid/dana/domain/autoroute/model/SecurityContext;", "getSecurityContextResult", "setSecurityContextResult", "(Lid/dana/domain/autoroute/model/SecurityContext;)V", "<init>", "(Lid/dana/domain/autoroute/model/Risk;Lid/dana/domain/autoroute/model/SecurityContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAutoRouteConfigSwitch extends BaseRpcResponse {
    private Risk riskResult;
    private SecurityContext securityContextResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.domain.autoroute.model.SecurityContext, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.autoroute.model.Risk] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UserAutoRouteConfigSwitch() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch.<init>():void");
    }

    public static /* synthetic */ UserAutoRouteConfigSwitch copy$default(UserAutoRouteConfigSwitch userAutoRouteConfigSwitch, Risk risk, SecurityContext securityContext, int i, Object obj) {
        if ((i & 1) != 0) {
            risk = userAutoRouteConfigSwitch.riskResult;
        }
        if ((i & 2) != 0) {
            securityContext = userAutoRouteConfigSwitch.securityContextResult;
        }
        return userAutoRouteConfigSwitch.copy(risk, securityContext);
    }

    /* renamed from: component1  reason: from getter */
    public final Risk getRiskResult() {
        return this.riskResult;
    }

    /* renamed from: component2  reason: from getter */
    public final SecurityContext getSecurityContextResult() {
        return this.securityContextResult;
    }

    public final UserAutoRouteConfigSwitch copy(Risk riskResult, SecurityContext securityContextResult) {
        return new UserAutoRouteConfigSwitch(riskResult, securityContextResult);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAutoRouteConfigSwitch) {
            UserAutoRouteConfigSwitch userAutoRouteConfigSwitch = (UserAutoRouteConfigSwitch) other;
            return Intrinsics.areEqual(this.riskResult, userAutoRouteConfigSwitch.riskResult) && Intrinsics.areEqual(this.securityContextResult, userAutoRouteConfigSwitch.securityContextResult);
        }
        return false;
    }

    public final int hashCode() {
        Risk risk = this.riskResult;
        int hashCode = risk == null ? 0 : risk.hashCode();
        SecurityContext securityContext = this.securityContextResult;
        return (hashCode * 31) + (securityContext != null ? securityContext.hashCode() : 0);
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAutoRouteConfigSwitch(riskResult=");
        sb.append(this.riskResult);
        sb.append(", securityContextResult=");
        sb.append(this.securityContextResult);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserAutoRouteConfigSwitch(Risk risk, SecurityContext securityContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : risk, (i & 2) != 0 ? null : securityContext);
    }

    @JvmName(name = "getRiskResult")
    public final Risk getRiskResult() {
        return this.riskResult;
    }

    @JvmName(name = "setRiskResult")
    public final void setRiskResult(Risk risk) {
        this.riskResult = risk;
    }

    @JvmName(name = "getSecurityContextResult")
    public final SecurityContext getSecurityContextResult() {
        return this.securityContextResult;
    }

    @JvmName(name = "setSecurityContextResult")
    public final void setSecurityContextResult(SecurityContext securityContext) {
        this.securityContextResult = securityContext;
    }

    public UserAutoRouteConfigSwitch(Risk risk, SecurityContext securityContext) {
        this.riskResult = risk;
        this.securityContextResult = securityContext;
    }
}
