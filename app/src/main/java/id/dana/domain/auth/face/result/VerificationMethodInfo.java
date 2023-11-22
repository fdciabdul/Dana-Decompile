package id.dana.domain.auth.face.result;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "", "", "priority", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "", CashierKeyParams.VERIFICATION_METHOD, "Ljava/lang/String;", "getVerificationMethod", "()Ljava/lang/String;", "setVerificationMethod", "(Ljava/lang/String;)V", "verificationMethodCode", "getVerificationMethodCode", "setVerificationMethodCode", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerificationMethodInfo {
    private Integer priority = 0;
    private String verificationMethod;
    private String verificationMethodCode;

    @JvmName(name = "getPriority")
    public final Integer getPriority() {
        return this.priority;
    }

    @JvmName(name = "setPriority")
    public final void setPriority(Integer num) {
        this.priority = num;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getVerificationMethodCode")
    public final String getVerificationMethodCode() {
        return this.verificationMethodCode;
    }

    @JvmName(name = "setVerificationMethodCode")
    public final void setVerificationMethodCode(String str) {
        this.verificationMethodCode = str;
    }
}
