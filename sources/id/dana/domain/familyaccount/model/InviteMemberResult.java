package id.dana.domain.familyaccount.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.autoroute.model.SecurityContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/domain/familyaccount/model/InviteMemberResult;", "", "", "invitationId", "Ljava/lang/String;", "getInvitationId", "()Ljava/lang/String;", "Lid/dana/domain/autoroute/model/SecurityContext;", "securityContext", "Lid/dana/domain/autoroute/model/SecurityContext;", "getSecurityContext", "()Lid/dana/domain/autoroute/model/SecurityContext;", BioUtilityBridge.SECURITY_ID, "getSecurityId", "", "userInvited", "Z", "getUserInvited", "()Z", "", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "verificationMethodInfoList", "Ljava/util/List;", "getVerificationMethodInfoList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Lid/dana/domain/autoroute/model/SecurityContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InviteMemberResult {
    private final String invitationId;
    private final SecurityContext securityContext;
    private final String securityId;
    private final boolean userInvited;
    private final List<VerificationMethodInfo> verificationMethodInfoList;

    public InviteMemberResult(String str, boolean z, List<VerificationMethodInfo> list, String str2, SecurityContext securityContext) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.invitationId = str;
        this.userInvited = z;
        this.verificationMethodInfoList = list;
        this.securityId = str2;
        this.securityContext = securityContext;
    }

    @JvmName(name = "getInvitationId")
    public final String getInvitationId() {
        return this.invitationId;
    }

    @JvmName(name = "getUserInvited")
    public final boolean getUserInvited() {
        return this.userInvited;
    }

    @JvmName(name = "getVerificationMethodInfoList")
    public final List<VerificationMethodInfo> getVerificationMethodInfoList() {
        return this.verificationMethodInfoList;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContext getSecurityContext() {
        return this.securityContext;
    }
}
