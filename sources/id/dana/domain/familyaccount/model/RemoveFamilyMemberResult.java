package id.dana.domain.familyaccount.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.autoroute.model.SecurityContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005"}, d2 = {"Lid/dana/domain/familyaccount/model/RemoveFamilyMemberResult;", "", "", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "Lid/dana/domain/autoroute/model/SecurityContext;", "component3", "()Lid/dana/domain/autoroute/model/SecurityContext;", "verificationMethodInfoList", BioUtilityBridge.SECURITY_ID, "securityContext", "copy", "(Ljava/util/List;Ljava/lang/String;Lid/dana/domain/autoroute/model/SecurityContext;)Lid/dana/domain/familyaccount/model/RemoveFamilyMemberResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/autoroute/model/SecurityContext;", "getSecurityContext", "Ljava/lang/String;", "getSecurityId", "Ljava/util/List;", "getVerificationMethodInfoList", "<init>", "(Ljava/util/List;Ljava/lang/String;Lid/dana/domain/autoroute/model/SecurityContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RemoveFamilyMemberResult {
    private final SecurityContext securityContext;
    private final String securityId;
    private final List<VerificationMethodInfo> verificationMethodInfoList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoveFamilyMemberResult copy$default(RemoveFamilyMemberResult removeFamilyMemberResult, List list, String str, SecurityContext securityContext, int i, Object obj) {
        if ((i & 1) != 0) {
            list = removeFamilyMemberResult.verificationMethodInfoList;
        }
        if ((i & 2) != 0) {
            str = removeFamilyMemberResult.securityId;
        }
        if ((i & 4) != 0) {
            securityContext = removeFamilyMemberResult.securityContext;
        }
        return removeFamilyMemberResult.copy(list, str, securityContext);
    }

    public final List<VerificationMethodInfo> component1() {
        return this.verificationMethodInfoList;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component3  reason: from getter */
    public final SecurityContext getSecurityContext() {
        return this.securityContext;
    }

    public final RemoveFamilyMemberResult copy(List<VerificationMethodInfo> verificationMethodInfoList, String securityId, SecurityContext securityContext) {
        Intrinsics.checkNotNullParameter(verificationMethodInfoList, "");
        return new RemoveFamilyMemberResult(verificationMethodInfoList, securityId, securityContext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RemoveFamilyMemberResult) {
            RemoveFamilyMemberResult removeFamilyMemberResult = (RemoveFamilyMemberResult) other;
            return Intrinsics.areEqual(this.verificationMethodInfoList, removeFamilyMemberResult.verificationMethodInfoList) && Intrinsics.areEqual(this.securityId, removeFamilyMemberResult.securityId) && Intrinsics.areEqual(this.securityContext, removeFamilyMemberResult.securityContext);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.verificationMethodInfoList.hashCode();
        String str = this.securityId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        SecurityContext securityContext = this.securityContext;
        return (((hashCode * 31) + hashCode2) * 31) + (securityContext != null ? securityContext.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoveFamilyMemberResult(verificationMethodInfoList=");
        sb.append(this.verificationMethodInfoList);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(')');
        return sb.toString();
    }

    public RemoveFamilyMemberResult(List<VerificationMethodInfo> list, String str, SecurityContext securityContext) {
        Intrinsics.checkNotNullParameter(list, "");
        this.verificationMethodInfoList = list;
        this.securityId = str;
        this.securityContext = securityContext;
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
