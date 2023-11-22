package id.dana.data.merchantmanagement.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.auth.face.result.SecurityContext;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/domain/auth/face/result/SecurityContext;", "component1", "()Lid/dana/domain/auth/face/result/SecurityContext;", "", "component2", "()Ljava/lang/String;", "securityContext", BioUtilityBridge.SECURITY_ID, "copy", "(Lid/dana/domain/auth/face/result/SecurityContext;Ljava/lang/String;)Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/auth/face/result/SecurityContext;", "getSecurityContext", "setSecurityContext", "(Lid/dana/domain/auth/face/result/SecurityContext;)V", "Ljava/lang/String;", "getSecurityId", "setSecurityId", "(Ljava/lang/String;)V", "<init>", "(Lid/dana/domain/auth/face/result/SecurityContext;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UnbindConsultResult extends BaseRpcResult {
    private SecurityContext securityContext;
    private String securityId;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.auth.face.result.SecurityContext, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UnbindConsultResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult.<init>():void");
    }

    public static /* synthetic */ UnbindConsultResult copy$default(UnbindConsultResult unbindConsultResult, SecurityContext securityContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            securityContext = unbindConsultResult.securityContext;
        }
        if ((i & 2) != 0) {
            str = unbindConsultResult.securityId;
        }
        return unbindConsultResult.copy(securityContext, str);
    }

    /* renamed from: component1  reason: from getter */
    public final SecurityContext getSecurityContext() {
        return this.securityContext;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final UnbindConsultResult copy(SecurityContext securityContext, String securityId) {
        return new UnbindConsultResult(securityContext, securityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UnbindConsultResult) {
            UnbindConsultResult unbindConsultResult = (UnbindConsultResult) other;
            return Intrinsics.areEqual(this.securityContext, unbindConsultResult.securityContext) && Intrinsics.areEqual(this.securityId, unbindConsultResult.securityId);
        }
        return false;
    }

    public final int hashCode() {
        SecurityContext securityContext = this.securityContext;
        int hashCode = securityContext == null ? 0 : securityContext.hashCode();
        String str = this.securityId;
        return (hashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnbindConsultResult(securityContext=");
        sb.append(this.securityContext);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UnbindConsultResult(SecurityContext securityContext, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : securityContext, (i & 2) != 0 ? null : str);
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContext getSecurityContext() {
        return this.securityContext;
    }

    @JvmName(name = "setSecurityContext")
    public final void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    public UnbindConsultResult(SecurityContext securityContext, String str) {
        this.securityContext = securityContext;
        this.securityId = str;
    }
}
