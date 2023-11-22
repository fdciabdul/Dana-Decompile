package id.dana.domain.familyaccount.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/domain/familyaccount/model/InvitationDecisionInfo;", "", "", BioUtilityBridge.SECURITY_ID, "Ljava/lang/String;", "getSecurityId", "()Ljava/lang/String;", "", "success", "Ljava/lang/Boolean;", "getSuccess", "()Ljava/lang/Boolean;", "", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "verificationMethodInfos", "Ljava/util/List;", "getVerificationMethodInfos", "()Ljava/util/List;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvitationDecisionInfo {
    private final String securityId;
    private final Boolean success;
    private final List<VerificationMethodInfo> verificationMethodInfos;

    public InvitationDecisionInfo(Boolean bool, List<VerificationMethodInfo> list, String str) {
        this.success = bool;
        this.verificationMethodInfos = list;
        this.securityId = str;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getVerificationMethodInfos")
    public final List<VerificationMethodInfo> getVerificationMethodInfos() {
        return this.verificationMethodInfos;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }
}
