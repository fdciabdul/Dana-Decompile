package id.dana.network.response.authface;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.bioutility.BioUtilityBridge;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR*\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'"}, d2 = {"Lid/dana/network/response/authface/FaceAuthenticationEntityResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "", "identFailedCount", "Ljava/lang/Integer;", "getIdentFailedCount", "()Ljava/lang/Integer;", "setIdentFailedCount", "(Ljava/lang/Integer;)V", "maxFailedLimit", "getMaxFailedLimit", "setMaxFailedLimit", "riskResult", "getRiskResult", "setRiskResult", "Lid/dana/network/response/authface/SecurityContextEntity;", "securityContext", "Lid/dana/network/response/authface/SecurityContextEntity;", "getSecurityContext", "()Lid/dana/network/response/authface/SecurityContextEntity;", "setSecurityContext", "(Lid/dana/network/response/authface/SecurityContextEntity;)V", BioUtilityBridge.SECURITY_ID, "getSecurityId", "setSecurityId", "", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "verificationMethods", "Ljava/util/List;", "getVerificationMethods", "()Ljava/util/List;", "setVerificationMethods", "(Ljava/util/List;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaceAuthenticationEntityResult extends BaseRpcResult {
    private String action;
    private Integer identFailedCount;
    private Integer maxFailedLimit;
    private String riskResult;
    private SecurityContextEntity securityContext;
    private String securityId;
    private List<VerificationMethodInfoEntity> verificationMethods;

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
    public final List<VerificationMethodInfoEntity> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(List<VerificationMethodInfoEntity> list) {
        this.verificationMethods = list;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContextEntity getSecurityContext() {
        return this.securityContext;
    }

    @JvmName(name = "setSecurityContext")
    public final void setSecurityContext(SecurityContextEntity securityContextEntity) {
        this.securityContext = securityContextEntity;
    }

    @JvmName(name = "getIdentFailedCount")
    public final Integer getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "setIdentFailedCount")
    public final void setIdentFailedCount(Integer num) {
        this.identFailedCount = num;
    }

    @JvmName(name = "getMaxFailedLimit")
    public final Integer getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    @JvmName(name = "setMaxFailedLimit")
    public final void setMaxFailedLimit(Integer num) {
        this.maxFailedLimit = num;
    }
}
