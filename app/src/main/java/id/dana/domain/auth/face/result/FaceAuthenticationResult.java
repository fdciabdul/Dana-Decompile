package id.dana.domain.auth.face.result;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "riskResult", "getRiskResult", "setRiskResult", "Lid/dana/domain/auth/face/result/SecurityContext;", "securityContext", "Lid/dana/domain/auth/face/result/SecurityContext;", "getSecurityContext", "()Lid/dana/domain/auth/face/result/SecurityContext;", "setSecurityContext", "(Lid/dana/domain/auth/face/result/SecurityContext;)V", BioUtilityBridge.SECURITY_ID, "getSecurityId", "setSecurityId", "", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "verificationMethods", "Ljava/util/List;", "getVerificationMethods", "()Ljava/util/List;", "setVerificationMethods", "(Ljava/util/List;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FaceAuthenticationResult extends BaseRpcResponse {
    private String action;
    private String riskResult;
    private SecurityContext securityContext;
    private String securityId;
    private List<VerificationMethodInfo> verificationMethods;

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getRiskResult")
    public final String getRiskResult() {
        return this.riskResult;
    }

    @JvmName(name = "setRiskResult")
    public final void setRiskResult(String str) {
        this.riskResult = str;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        this.action = str;
    }

    @JvmName(name = "getVerificationMethods")
    public final List<VerificationMethodInfo> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(List<VerificationMethodInfo> list) {
        this.verificationMethods = list;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContext getSecurityContext() {
        return this.securityContext;
    }

    @JvmName(name = "setSecurityContext")
    public final void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }
}
