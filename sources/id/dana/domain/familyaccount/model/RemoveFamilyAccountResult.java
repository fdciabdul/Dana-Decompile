package id.dana.domain.familyaccount.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.autoroute.model.SecurityContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0004R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\b"}, d2 = {"Lid/dana/domain/familyaccount/model/RemoveFamilyAccountResult;", "", "", "component1", "()Z", "", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "Lid/dana/domain/autoroute/model/SecurityContext;", "component4", "()Lid/dana/domain/autoroute/model/SecurityContext;", "success", "verificationMethodInfoList", BioUtilityBridge.SECURITY_ID, "securityContext", "copy", "(ZLjava/util/List;Ljava/lang/String;Lid/dana/domain/autoroute/model/SecurityContext;)Lid/dana/domain/familyaccount/model/RemoveFamilyAccountResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/autoroute/model/SecurityContext;", "getSecurityContext", "Ljava/lang/String;", "getSecurityId", "Z", "getSuccess", "Ljava/util/List;", "getVerificationMethodInfoList", "<init>", "(ZLjava/util/List;Ljava/lang/String;Lid/dana/domain/autoroute/model/SecurityContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RemoveFamilyAccountResult {
    private final SecurityContext securityContext;
    private final String securityId;
    private final boolean success;
    private final List<VerificationMethodInfo> verificationMethodInfoList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoveFamilyAccountResult copy$default(RemoveFamilyAccountResult removeFamilyAccountResult, boolean z, List list, String str, SecurityContext securityContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = removeFamilyAccountResult.success;
        }
        if ((i & 2) != 0) {
            list = removeFamilyAccountResult.verificationMethodInfoList;
        }
        if ((i & 4) != 0) {
            str = removeFamilyAccountResult.securityId;
        }
        if ((i & 8) != 0) {
            securityContext = removeFamilyAccountResult.securityContext;
        }
        return removeFamilyAccountResult.copy(z, list, str, securityContext);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final List<VerificationMethodInfo> component2() {
        return this.verificationMethodInfoList;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component4  reason: from getter */
    public final SecurityContext getSecurityContext() {
        return this.securityContext;
    }

    public final RemoveFamilyAccountResult copy(boolean success, List<VerificationMethodInfo> verificationMethodInfoList, String securityId, SecurityContext securityContext) {
        Intrinsics.checkNotNullParameter(verificationMethodInfoList, "");
        return new RemoveFamilyAccountResult(success, verificationMethodInfoList, securityId, securityContext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RemoveFamilyAccountResult) {
            RemoveFamilyAccountResult removeFamilyAccountResult = (RemoveFamilyAccountResult) other;
            return this.success == removeFamilyAccountResult.success && Intrinsics.areEqual(this.verificationMethodInfoList, removeFamilyAccountResult.verificationMethodInfoList) && Intrinsics.areEqual(this.securityId, removeFamilyAccountResult.securityId) && Intrinsics.areEqual(this.securityContext, removeFamilyAccountResult.securityContext);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.verificationMethodInfoList.hashCode();
        String str = this.securityId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        SecurityContext securityContext = this.securityContext;
        return (((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + (securityContext != null ? securityContext.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoveFamilyAccountResult(success=");
        sb.append(this.success);
        sb.append(", verificationMethodInfoList=");
        sb.append(this.verificationMethodInfoList);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(')');
        return sb.toString();
    }

    public RemoveFamilyAccountResult(boolean z, List<VerificationMethodInfo> list, String str, SecurityContext securityContext) {
        Intrinsics.checkNotNullParameter(list, "");
        this.success = z;
        this.verificationMethodInfoList = list;
        this.securityId = str;
        this.securityContext = securityContext;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
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
